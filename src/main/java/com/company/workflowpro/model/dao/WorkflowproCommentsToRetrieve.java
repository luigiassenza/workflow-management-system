package com.company.workflowpro.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.company.workflowpro.connection.MySQLCnn;
import com.company.workflowpro.model.dto.WorkflowproCommentDetail;

public class WorkflowproCommentsToRetrieve {
	
	Connection c = null;
	
	public WorkflowproCommentsToRetrieve () {
		
		c = new MySQLCnn().getCnn();
		
	}
	
	public ArrayList<WorkflowproCommentDetail> getComments(int idWorkflowpro) throws SQLException {
		
		ArrayList<WorkflowproCommentDetail> comments = new ArrayList<WorkflowproCommentDetail>();
		String sql = "SELECT * FROM workflowpro_comments WHERE id_workflowpro = ?";
		PreparedStatement pst = c.prepareStatement(sql);
		pst.setInt(1, idWorkflowpro);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			WorkflowproCommentDetail comment = new WorkflowproCommentDetail();
			comment.setId(rs.getInt("id"));
			comment.setCommentDate(rs.getDate("comment_date"));
			comment.setIdWorkflowpro(rs.getInt("id_workflowpro"));
			comment.setUsername(rs.getString("username"));
			comment.setComment(rs.getString("comments"));
			comments.add(comment);
		}
		c.close();
		return comments;
		
	}

}
