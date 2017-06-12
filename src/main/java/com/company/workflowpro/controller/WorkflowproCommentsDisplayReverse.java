package com.company.workflowpro.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.workflowpro.model.dao.WorkflowproCommentsToRetrieveReverse;
import com.company.workflowpro.model.dto.WorkflowproCommentDetail;


public class WorkflowproCommentsDisplayReverse extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<WorkflowproCommentDetail> commentsReverse = new WorkflowproCommentsToRetrieveReverse().getCommentsReverse();
			request.setAttribute("commentsReverse", commentsReverse);
			request.getRequestDispatcher("commentsreverse.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
