package com.company.workflowpro.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.workflowpro.model.dao.WorkflowproCommentsToRegister;
import com.company.workflowpro.model.dto.WorkflowproCommentDetail;

public class WorkflowproCommentsRegister extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ArrayList<WorkflowproCommentDetail> comments = new ArrayList<WorkflowproCommentDetail>();
		int idWorkflowpro = Integer.parseInt(request.getParameter("idWorkflowpro"));
		String username = request.getParameter("username");
		String comment = request.getParameter("comment");
		WorkflowproCommentsToRegister commentsRegister = new WorkflowproCommentsToRegister();
		//request.getRequestDispatcher("WorkflowproUpdate").forward(request, response);
		try {
			commentsRegister.register(idWorkflowpro, username, comment);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
