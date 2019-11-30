package com.fedx.api.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UploadFilesRequest {

	@NotEmpty
	private String projectId;
	@NotEmpty
	private String branch;
	private String folderPath;
	@NotEmpty
	private String commitMessage;
	@NotEmpty
	private MultipartFile[] uploadFiles;
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getFolderPath() {
		return folderPath;
	}
	public void setFolderPath(String folderPath) {
		this.folderPath = folderPath;
	}
	public String getCommitMessage() {
		return commitMessage;
	}
	public void setCommitMessage(String commitMessage) {
		this.commitMessage = commitMessage;
	}
	public MultipartFile[] getUploadFiles() {
		return uploadFiles;
	}
	public void setUploadFiles(MultipartFile[] uploadFiles) {
		this.uploadFiles = uploadFiles;
	}
	
	
}
