package com.fedx.api.service;

import java.io.IOException;
import java.net.URI;
import java.util.Base64;
import java.util.Collections;
import java.util.Optional;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.fedx.api.controller.RequestResponseLoggingInterceptor;
import com.fedx.api.model.APIResponse;
import com.fedx.api.model.FileAction;
import com.fedx.api.model.MultiCommitRequest;
import com.fedx.api.model.MultiCommitResponse;
import com.fedx.api.model.UploadFilesRequest;

@Service
public class UploadFilesServiceImpl implements UploadFilesService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UploadFilesServiceImpl.class);

	@Value("${gitlab.access_token}")
	private String gitLabPAT;

	@Value("${gitlab.file.multicommit.url}")
	private String fileCommitURL;

	@Override
	public APIResponse uploadFiles(UploadFilesRequest uploadFilesRequest) {

		MultipartFile[] uploadFiles = uploadFilesRequest.getUploadFiles();

		MultiCommitRequest commitRequest = new MultiCommitRequest();
		commitRequest.setBranch(uploadFilesRequest.getBranch());
		commitRequest.setCommit_message(uploadFilesRequest.getCommitMessage());

		String folderPath = Optional.ofNullable(uploadFilesRequest.getFolderPath()).orElse("");
		if (!folderPath.equals("") && !folderPath.endsWith("/")) {
			folderPath += "/";
		}

		for (MultipartFile uploadFile : uploadFiles) {

			LOGGER.info("Uploading file: {} ", uploadFile.getOriginalFilename());
			
			FileAction fileAction = new FileAction();			
			fileAction.setAction("create");
			fileAction.setFile_path(folderPath + uploadFile.getOriginalFilename());
			fileAction.setEncoding("base64");

			try {
				String base64format = Base64.getEncoder().encodeToString(uploadFile.getBytes());
				fileAction.setContent(base64format);
				commitRequest.getActions().add(fileAction);
			} catch (IOException ex) {
				LOGGER.error("Error while creating request: ", ex);
				return new APIResponse(false, "Error while preparing commit request: " + ex.getMessage());
			}
		}

		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON.toString());
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.add("PRIVATE-TOKEN", gitLabPAT);

		HttpEntity<MultiCommitRequest> requestEntity = new HttpEntity<>(commitRequest, headers);
		ResponseEntity<MultiCommitResponse> commitResponse = null;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));

		try {

			String commitURL = String.format(fileCommitURL, "15427851");
			URI uri = UriComponentsBuilder.fromUriString(commitURL).build(true).toUri();

			commitResponse = restTemplate.exchange(uri, HttpMethod.POST, requestEntity, MultiCommitResponse.class);
		} catch (Exception ex) {
			LOGGER.error("Error while uploading: ", ex);
		}

		return new APIResponse(true, "Files are uploaded successfully.");
	}
}
