package com.company.workflowpro.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.workflowpro.model.dao.WorkflowproEmployeeToRetrieve;
import com.company.workflowpro.model.dto.WorkflowproDetailEmployee;

/**
 * Servlet implementation class WorkflowproEmployeeChangeBack
 */
public class WorkflowproEmployeeChangeBack extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkflowproEmployeeChangeBack() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<WorkflowproDetailEmployee> employees;
		try {
			employees = new WorkflowproEmployeeToRetrieve().getEmployees();
			request.setAttribute("employees", employees);
			request.getRequestDispatcher("employee.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
