package com.company.workflowpro.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.workflowpro.connection.ParentDirectory;

@javax.servlet.annotation.MultipartConfig
public class WorkflowproFilesDownload extends HttpServlet {
   	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parentDirectory = new ParentDirectory().getParentDirectory();
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		String filename = request.getParameter("fileName");
		String id = request.getParameter("id");
		String filepath = parentDirectory + id + "/";
		response.setContentType("APPLICATION/OCTET-STREAM");   
		response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");   
		  
		FileInputStream fileInputStream = new FileInputStream(filepath + filename);  
		            
		int i;   
		while ((i=fileInputStream.read()) != -1) {  
		out.write(i);   
		}   
		fileInputStream.close();   
		out.close();   
	}

}
