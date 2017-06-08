package com.company.workflowpro.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.company.workflowpro.connection.MySQLCnn;

public class WorkflowproTaskToRegister {

		
		Connection c = null;
		
		public WorkflowproTaskToRegister() {
			c = new MySQLCnn().getCnn();
		}
		
		public void save(String name, String task, String comments, HttpServletRequest request, ServletFileUpload sf) {
			try {
				String sql = "INSERT INTO workflowpro (name, task, status, comments) VALUES(?,?,?,?)";
				PreparedStatement prs = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				prs.setString(1, name);
				prs.setString(2, task);
				prs.setString(3,"Registered");
				prs.setString(4, comments);
				prs.executeUpdate();
				ResultSet key = prs.getGeneratedKeys();
				key.next();
			      int keys = key.getInt(1);
					
				c.close();
				WorkflowproDirectoryToCreate directory = new WorkflowproDirectoryToCreate();
				directory.createDirectory(keys);
				
				WorkflowproDirectoryToCreate files = new WorkflowproDirectoryToCreate();
				files.saveFiles(keys, request, sf);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

