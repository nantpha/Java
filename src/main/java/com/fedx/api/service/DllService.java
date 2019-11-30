package com.fedx.api.service;

import com.fedx.api.model.DllCommitRequest;
import com.fedx.api.model.DllCommitResponse;


public interface DllService {

	DllCommitResponse commitFie(DllCommitRequest dllCommitRequest);
}
