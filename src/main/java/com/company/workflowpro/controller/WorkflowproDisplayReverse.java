package com.company.workflowpro.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.workflowpro.model.dao.WorkflowproToDisplayReverse;
import com.company.workflowpro.model.dto.WorkflowproDetail;


public class WorkflowproDisplayReverse extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<WorkflowproDetail> workflowsproreverse = new WorkflowproToDisplayReverse().getDataReverse();
			request.setAttribute("workflowsproreverse", workflowsproreverse);
			request.getRequestDispatcher("workflowproreverse.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
