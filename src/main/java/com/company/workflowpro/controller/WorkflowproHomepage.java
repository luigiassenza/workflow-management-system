package com.company.workflowpro.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.workflowpro.model.dao.WorkflowproChartToDisplay;
import com.company.workflowpro.model.dao.WorkflowproToSummary;
import com.company.workflowpro.model.dto.WorkflowproDetailChart;
import com.company.workflowpro.model.dto.WorkflowproSummaryNameStatusDetail;
import com.company.workflowpro.model.dto.WorkflowproSummaryStatusDetail;


public class WorkflowproHomepage extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			WorkflowproChartToDisplay updateCurrentTime = new WorkflowproChartToDisplay();
			updateCurrentTime.updateCurrentTime();
			ArrayList<WorkflowproDetailChart> workflows = new WorkflowproChartToDisplay().getChart();
			request.setAttribute("workflows", workflows);
			
			ArrayList<WorkflowproSummaryStatusDetail> statusDetail = new WorkflowproToSummary().byStatus();
			request.setAttribute("statusDetail", statusDetail);
			
			ArrayList<WorkflowproSummaryNameStatusDetail> statusNameDetail = new WorkflowproToSummary().getSummaryNameStatus();			
			request.setAttribute("statusNameDetail", statusNameDetail);
			
			ArrayList<WorkflowproSummaryNameStatusDetail> statusNameDetailOutstanding = new WorkflowproToSummary().getSummaryNameStatusOutstanding();			
			request.setAttribute("statusNameDetailOutstanding", statusNameDetailOutstanding);
			
			request.getRequestDispatcher("homepage.jsp").forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
