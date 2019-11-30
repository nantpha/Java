package com.fedx.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fedx.api.model.DllCommitRequest;
import com.fedx.api.model.DllCommitResponse;
import com.fedx.api.service.DllService;

@RestController
@RequestMapping("/dll")
public class DllController {

	private static final Logger LOG = LoggerFactory.getLogger(DllController.class);

	@Autowired
	private DllService dllService;

	@PostMapping("/commit")
	public DllCommitResponse commitFileToGit(@RequestBody DllCommitRequest dllCommitRequest) {

		LOG.info("GitLab commit request received for fie: {}", dllCommitRequest.getFile());

		return dllService.commitFie(dllCommitRequest);
	}
}
