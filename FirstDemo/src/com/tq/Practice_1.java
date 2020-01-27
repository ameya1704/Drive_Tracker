package com.tq;
import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
/**
 * Servlet implementation class Practice_1
 */

@WebServlet("/Practice_1")
public class Practice_1 implements Servlet
{   
	/**
     * @see HttpServlet#HttpServlet()
     */
	
    public Practice_1()
    {
        super();
        System.out.println("In Constructor !!");
    }

	@Override
	public void init(ServletConfig config) throws ServletException
	{
		System.out.println("In init method !!");
	}

	@Override
	public ServletConfig getServletConfig()
	{
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
		System.out.println("In Service !!");
	}

	@Override
	public String getServletInfo()
	{
		return null;
	}

	@Override
	public void destroy()
	{
		System.out.println("In Destroyy !!");
	}
}