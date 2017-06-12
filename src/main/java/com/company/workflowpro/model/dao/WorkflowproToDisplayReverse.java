package com.company.workflowpro.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.company.workflowpro.connection.MySQLCnn;
import com.company.workflowpro.model.dto.WorkflowproDetail;

public class WorkflowproToDisplayReverse {
	
Connection c = null;
	
	public WorkflowproToDisplayReverse() {
		
		c = new MySQLCnn().getCnn();
		
	}
	
	public ArrayList<WorkflowproDetail> getDataReverse() throws SQLException {
		
		ArrayList<WorkflowproDetail> workflowspro = new ArrayList<WorkflowproDetail>();
		String sql = "SELECT * FROM workflowpro ORDER BY end DESC";
		PreparedStatement pst = c.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			WorkflowproDetail workflowpro = new WorkflowproDetail();
			workflowpro.setId(rs.getInt("id"));
			workflowpro.setName(rs.getString("name"));
			workflowpro.setTask(rs.getString("task"));
			workflowpro.setStart(rs.getDate("start"));
			workflowpro.setEnd(rs.getDate("end"));
			workflowpro.setStatus(rs.getString("status"));
			workflowpro.setComments(rs.getString("comments"));
			workflowspro.add(workflowpro);
		}
		c.close();
		return workflowspro;
		
	}

}
