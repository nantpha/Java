package com.fedx.api.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


public class MultiCommitRequest {

	private String branch;
	private String commit_message;
	private List<FileAction> actions = new ArrayList<>();
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getCommit_message() {
		return commit_message;
	}
	public void setCommit_message(String commit_message) {
		this.commit_message = commit_message;
	}
	public List<FileAction> getActions() {
		return actions;
	}
	public void setActions(List<FileAction> actions) {
		this.actions = actions;
	}
	
	
}
