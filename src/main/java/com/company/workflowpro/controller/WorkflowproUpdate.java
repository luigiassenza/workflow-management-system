package com.company.workflowpro.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.workflowpro.model.dao.WorkflowproDirectoryToCreate;
import com.company.workflowpro.model.dao.WorkflowproEmployeeToRetrieve;
import com.company.workflowpro.model.dao.WorkflowproToUpdate;
import com.company.workflowpro.model.dto.WorkflowproDetail;
import com.company.workflowpro.model.dto.WorkflowproDetailEmployee;

/**
 * Servlet implementation class WorkflowproUpdate
 */
public class WorkflowproUpdate extends HttpServlet {
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int idInt = Integer.parseInt(id);
		try {
			ArrayList<WorkflowproDetail> details = new WorkflowproToUpdate().getDetail(idInt);
			request.setAttribute("details", details);
			
			ArrayList<WorkflowproDetailEmployee> employees = new WorkflowproEmployeeToRetrieve().getEmployees();
			request.setAttribute("employees", employees);
			
			WorkflowproDirectoryToCreate directory = new WorkflowproDirectoryToCreate();
			directory.createDirectory(idInt);
			
			//Show files uploaded
			ArrayList<String> fileNames = new ArrayList<String>();
			ArrayList<String> filePaths = new ArrayList<String>();
			String parentDirectory = "C:\\Users\\User\\Desktop\\documents\\";
			String message = "";
			File f = new File(parentDirectory + id);
			File[] files = f.listFiles();
			if(f.exists()) {
				for(File file : files) {
					if(file.isDirectory()) {
						System.out.println("This file is a directory");
					} else {
						String path = file.getAbsolutePath();
						filePaths.add(path);
						String name = file.getName();
						fileNames.add(name);
						
					}
				}
			} else {
				message = "";
			}
			
			request.setAttribute("fileNames", fileNames);
			request.setAttribute("filePaths", filePaths);
			request.setAttribute("message", message);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
