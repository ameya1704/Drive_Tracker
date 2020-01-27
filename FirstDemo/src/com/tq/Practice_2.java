package com.tq;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Practice_2
 */
@SuppressWarnings("serial")
@WebServlet("/Practice_2")
public class Practice_2 extends HttpServlet
{
//	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Practice_2()
    {
        super();
        System.out.println("In Constructor !!");
    }
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("Service 2");
		doGet(req, resp);
		System.out.println("Servicein Process !!");
		doPost(req,resp);
		System.out.println("Service 2 ");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
		System.out.println("Service 1 !!");
		super.service(req, res);
		System.out.println("Service 1 !!");	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("In doGet !!");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("In doPost !!");
	//	doGet(request, response);
	}

	@Override
	public void init(ServletConfig config) throws ServletException
	{
		System.out.println("In init !!");
	}

	@Override
	public ServletConfig getServletConfig()
	{
		return null;
	}

	@Override
	public String getServletInfo()
	{
		return null;
	}

	@Override
	public void destroy()
	{
		
	}
}