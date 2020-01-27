package com.tq;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tq.Student;
import com.tq.StudentService;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/AddStudent")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String sname = request.getParameter("sname");
		String strAge = request.getParameter("age");
		
		int age = Integer.parseInt(strAge);
		Student s = new Student();
		s.setSname(sname);
		s.setAge(age);
		
		int status = StudentService.addStudent(s);
		
		System.out.println(" student added " + status);
		
		response.getWriter().write(status + " students with name " + sname + "  added in db "); 
	}

}
