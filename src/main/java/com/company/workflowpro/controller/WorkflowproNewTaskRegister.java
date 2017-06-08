package com.company.workflowpro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.company.workflowpro.model.dao.WorkflowproTaskToRegister;

@javax.servlet.annotation.MultipartConfig 
public class WorkflowproNewTaskRegister extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String task = request.getParameter("task");
		String comments = request.getParameter("comments");
		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		
		WorkflowproTaskToRegister registration = new WorkflowproTaskToRegister();
		registration.save(name, task, comments, request, sf);
				
		response.sendRedirect("./WorkflowproDisplay");
	}

}
