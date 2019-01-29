package com.maven.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.maven.employee.DataAccessException;
import com.maven.employee.Employee;
import com.maven.employee.EmployeeDao;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MainServlet() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		doGet(request, response);
		int empno = Integer.parseInt(request.getParameter("empno"));
		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		
		EmployeeDao enter = new EmployeeDao();
		
		Employee emp = new Employee();
		
		emp.setName(name);
		emp.setSalary(salary);
		emp.setEmpNo(empno);
		
		try {
			enter.add(emp);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("message", "Record added successfully");
		
		response.sendRedirect("addEmp.jsp");
	}

}
