package com.company.workflowpro.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.company.workflowpro.connection.ParentDirectory;
import com.company.workflowpro.model.dao.WorkflowproToUpdate;

@javax.servlet.annotation.MultipartConfig 
public class WorkflowproUpdateRegister extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String parentDirectory = new ParentDirectory().getParentDirectory();
			int id = 0;
			String name = null;
			String task = null;
			String comments = null;
			String idString = null;
		
	        List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
	        Iterator<FileItem> iter = items.iterator();
	        while(iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				if(item.isFormField()) {
					String fieldName = item.getFieldName();
					String fieldValue = item.getString();
					if(fieldName.equals("id")) {
						id = Integer.parseInt(fieldValue);
						idString = Integer.toString(id);
					} else if(fieldName.equals("name")) {
						name = fieldValue;
					} else if(fieldName.equals("task")) {
						task = fieldValue;
					} else if(fieldName.equals("comments")) {
						comments = fieldValue;
					}
					
				} else if(!item.isFormField()) {
					ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
					WorkflowproToUpdate update = new WorkflowproToUpdate();
					update.update(id, name, task, comments, request, sf);
					String fileName = new File(item.getName()).getName();
					if(!fileName.isEmpty()) {
						String filePath = parentDirectory + idString + File.separator + fileName;
						File storeFile = new File(filePath);
						item.write(storeFile);
					}
				}
	        }
			
			response.sendRedirect("./WorkflowproDisplay");

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
