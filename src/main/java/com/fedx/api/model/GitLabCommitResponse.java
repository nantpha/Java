package com.fedx.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


public class GitLabCommitResponse {

	private String file_path;
	private String branch;
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "GitLabCommitResponse [file_path=" + file_path + ", branch=" + branch + "]";
	}
	
	
}
