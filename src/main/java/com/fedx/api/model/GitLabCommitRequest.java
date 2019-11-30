package com.fedx.api.model;

import lombok.Getter;
import lombok.Setter;


public class GitLabCommitRequest {

	private String branch;
	private String author_email;
	private String author_name;
	private String content;
	private String commit_message;
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getAuthor_email() {
		return author_email;
	}
	public void setAuthor_email(String author_email) {
		this.author_email = author_email;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCommit_message() {
		return commit_message;
	}
	public void setCommit_message(String commit_message) {
		this.commit_message = commit_message;
	}
	
	
}
