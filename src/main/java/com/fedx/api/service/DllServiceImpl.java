package com.fedx.api.service;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fedx.api.model.DllCommitRequest;
import com.fedx.api.model.DllCommitResponse;
import com.fedx.api.model.GitLabCommitRequest;
import com.fedx.api.model.GitLabCommitResponse;
import com.fedx.api.controller.RequestResponseLoggingInterceptor;

@Service
public class DllServiceImpl implements DllService {

	private static final Logger LOG = LoggerFactory.getLogger(DllServiceImpl.class);

	@Value("${gitlab.access_token}")
	private String gitLabPAT;

	@Value("${gitlab.file.commit.url}")
	private String fileCommitURL;

	@Override
	public DllCommitResponse commitFie(DllCommitRequest dllCommitRequest) {

		GitLabCommitRequest commitRequestEntity = convertToGitRequest(dllCommitRequest);
		DllCommitResponse response = new DllCommitResponse();
		response.setSuccess(true);
		response.setMessage("File has been committed successfully.");

		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON.toString());
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.add("PRIVATE-TOKEN", gitLabPAT);

		HttpEntity<GitLabCommitRequest> requestEntity = new HttpEntity<>(commitRequestEntity, headers);
		ResponseEntity<GitLabCommitResponse> commitResponse = null;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));

		try {

			String commitURL = String.format(fileCommitURL, dllCommitRequest.getProjectId(),
					encodeFile(dllCommitRequest.getFile()));
			LOG.info("Commit URL: {}", commitURL);

			URI uri = UriComponentsBuilder.fromUriString(commitURL).build(true).toUri();

			commitResponse = restTemplate.exchange(uri, HttpMethod.PUT, requestEntity, GitLabCommitResponse.class);
			LOG.info("Commit response: {}", commitResponse);
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage("Error while committing: " + e.getMessage());
		}

		return response;
	}

	private GitLabCommitRequest convertToGitRequest(DllCommitRequest dllCommitRequest) {

		GitLabCommitRequest commitRequest = new GitLabCommitRequest();
		commitRequest.setBranch(dllCommitRequest.getBranch());
		commitRequest.setAuthor_email(dllCommitRequest.getAuthorEmail());
		commitRequest.setAuthor_name(dllCommitRequest.getAuthorName());
		commitRequest.setContent(dllCommitRequest.getContent());
		commitRequest.setCommit_message("Commit via application");

		return commitRequest;
	}

	private String encodeFile(String fileName) throws UnsupportedEncodingException {
		String encodedName = URLEncoder.encode(fileName, "UTF-8");
		int index = encodedName.lastIndexOf(".");
		if (index != -1) {
			String tmp = encodedName.substring(0, index) + "%2E" + encodedName.substring(index + 1);
			encodedName = tmp;
		}
		return encodedName;
	}
}
