package com.company.workflowpro.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.company.workflowpro.connection.MySQLCnn;

public class WorkflowproCommentsToRegister {
	
	Connection c = null;
	
	public WorkflowproCommentsToRegister() {
		
		c = new MySQLCnn().getCnn();
		
	}
	
	public void register(int idWorkflowpro, String username, String comment) throws SQLException {
		String sql = "INSERT INTO workflowpro_comments (id_workflowpro, username, comments) VALUES (?,?,?)";
		PreparedStatement pst = c.prepareStatement(sql);
		pst.setInt(1, idWorkflowpro);
		pst.setString(2, username);
		pst.setString(3, comment);
		pst.executeUpdate();
		c.close();
	}

}
