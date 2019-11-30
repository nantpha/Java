package com.fedx.api.controller;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fedx.api.model.APIResponse;
import com.fedx.api.model.UploadFilesRequest;
import com.fedx.api.service.UploadFilesService;

@RestController
@RequestMapping("/uploadfiles")
public class UploadFileController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UploadFileController.class);

	@Autowired
	private UploadFilesService uploadFilesService;

	@PostMapping
	public APIResponse uploadFiles(@Valid UploadFilesRequest uploadFilesRequest, BindingResult result)
			throws IllegalStateException, IOException, ServletException {

		if (result.hasErrors()) {
			String fields = result.getFieldErrors().stream().map(FieldError::getField).collect(Collectors.joining(","));
			return new APIResponse(false, "Validation failed on: " + fields);
		}

		int noOfFiles = Optional.ofNullable(uploadFilesRequest.getUploadFiles()).map(ary -> ary.length).orElse(0);
		LOGGER.info("Uploading {} files for project: {} " + noOfFiles, uploadFilesRequest.getProjectId());

		uploadFilesService.uploadFiles(uploadFilesRequest);

		return new APIResponse(true, "Files are uploaded successfully.");
	}
}
