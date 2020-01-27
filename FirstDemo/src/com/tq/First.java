package com.tq;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class First
 */

public class First extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private int counter = 0;
    /**
     * Default constructor. 
     */
    public First() {
        // TODO Auto-generated constructor stub
    	System.out.println("Hello Ameya"+this.hashCode());
    }
    @Override
    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException
    {    	
//    	String fname =req.getParameter("uname");
//    	System.out.println(fname);
//    
    	resp.setContentType("text/html");
//    	PrintWriter out = resp.getWriter();
//    	out.println("Test");
//    	out.println("<b>Test</b>");
//		//String p ="Servlet";
//    	if(fname.equals("Servlet"))
//    	{
//    		RequestDispatcher rd = req.getRequestDispatcher("Second");
//    		rd.forward(req, resp);
//    	}
//    	else
//    	{
//    		System.out.println("Wrong");
//    		RequestDispatcher rd = req.getRequestDispatcher("Login.html");
//    		rd.include(req, resp);
//    	}
    	String name = req.getParameter("uname");
    	resp.sendRedirect("/FirstDemo/Second");
    }
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("In Init");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("In Destroy");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void servicenotinused(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	//	super.service(request, response);
	}

}
