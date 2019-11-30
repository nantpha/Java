package com.fedx.api.service;

import com.fedx.api.model.APIResponse;
import com.fedx.api.model.UploadFilesRequest;

public interface UploadFilesService {

	APIResponse uploadFiles(UploadFilesRequest uploadFilesRequest);
}
