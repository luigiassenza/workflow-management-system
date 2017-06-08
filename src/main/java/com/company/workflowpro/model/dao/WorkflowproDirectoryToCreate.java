package com.company.workflowpro.model.dao;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.company.workflowpro.connection.ParentDirectory;

public class WorkflowproDirectoryToCreate {
	
	String parentDirectory = new ParentDirectory().getParentDirectory();
	
	
	public void createDirectory(int id) {
		String idString = Integer.toString(id);
		File directory = new File(parentDirectory + idString);
		if(!directory.exists()) {
			directory.mkdirs();
		}
	}
	
	public void saveFiles(int id, HttpServletRequest request, ServletFileUpload sf) throws Exception {
		String idString = Integer.toString(id);
		sf = new ServletFileUpload(new DiskFileItemFactory());
		List<FileItem> multiples = sf.parseRequest(request);
		for(FileItem item : multiples) {
			item.write(new File(parentDirectory + idString + "\\" + item.getName()));
		}

	}
	
	
	public void saveFiles2(int id, HttpServletRequest request) throws FileUploadException {
		String idString = Integer.toString(id);
		File uploads = new File(parentDirectory + "\\" + idString);
        List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
        Iterator<FileItem> iter = items.iterator();
			try {
				while(iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					item.write(uploads);
				}
				/*
				for(FileItem item : items) {
					if(!item.isFormField()) {
						InputStream fileContent = item.getInputStream();
						File file = new File(uploads, item.getName());
						Files.copy(fileContent, file.toPath());
						
					}
				}
				*/
			} catch(Exception e) {
				e.printStackTrace();
			}
		
	}
	
	
}
