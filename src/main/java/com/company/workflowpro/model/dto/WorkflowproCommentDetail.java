package com.company.workflowpro.model.dto;

import java.util.Date;

public class WorkflowproCommentDetail {
	
	private int id;
	private Date commentDate;
	private int idWorkflowpro;
	private String username;
	private String comment;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getCommentDate() {
		return commentDate;
	}
	
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	
	public int getIdWorkflowpro() {
		return idWorkflowpro;
	}
	
	public void setIdWorkflowpro(int idWorkflowpro) {
		this.idWorkflowpro = idWorkflowpro;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String toString() {
		return id + " " + commentDate + " " + idWorkflowpro + " " + username +" " + comment;
	}

}
