package com.company.workflowpro.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.workflowpro.model.dao.WorkflowproCommentsToRetrieve;
import com.company.workflowpro.model.dto.WorkflowproCommentDetail;

public class WorkflowproCommentsDisplay extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int idWorkflowpro = Integer.parseInt(request.getParameter("idWorkflowpro"));
			ArrayList<WorkflowproCommentDetail> comments = new WorkflowproCommentsToRetrieve().getComments(idWorkflowpro);
			request.setAttribute("comments", comments);
			request.getRequestDispatcher("comments.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
