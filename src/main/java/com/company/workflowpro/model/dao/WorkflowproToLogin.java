package com.company.workflowpro.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.workflowpro.connection.MySQLCnn;

public class WorkflowproToLogin {
	
	Connection c = null;
	
	public WorkflowproToLogin() {
		
		c = new MySQLCnn().getCnn();
		
	}
	
	public boolean login(String username) throws SQLException {
		boolean result;
		String sql = "SELECT * FROM employees WHERE BINARY name = ?"; //BINARY to be case sensitive
		PreparedStatement pst = c.prepareStatement(sql);
		pst.setString(1, username);
		ResultSet rs = pst.executeQuery();
		if(!rs.isBeforeFirst()) {
			result = false;
		} else {
			result = true;
		}
		c.close();
		return result;
	}
	
}
