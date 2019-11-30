package com.fedx.api.model;

import lombok.Getter;
import lombok.Setter;


public class MultiCommitResponse {

	private String id;
	private String title;
	private String message;
	private Stats stats;
	private String status;
	

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Stats getStats() {
		return stats;
	}


	public void setStats(Stats stats) {
		this.stats = stats;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	
	static class Stats {
		private int additions;
		private int deletions;
		private int total;
		public int getAdditions() {
			return additions;
		}
		public void setAdditions(int additions) {
			this.additions = additions;
		}
		public int getDeletions() {
			return deletions;
		}
		public void setDeletions(int deletions) {
			this.deletions = deletions;
		}
		public int getTotal() {
			return total;
		}
		public void setTotal(int total) {
			this.total = total;
		}
		
		
	}

}
