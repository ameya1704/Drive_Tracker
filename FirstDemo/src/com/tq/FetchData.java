package com.tq;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FetchData
 */
//@WebServlet("/FetchData")
public class FetchData extends HttpServlet
{
	private static final long serialVersionUID = 1L;

    public FetchData()
    {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {	  
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();
		out.print("This is User Database ");
		try
		{  
		//Retrieving connection object from ServletContext object  
		ServletContext ctx=getServletContext();  
		Connection con=(Connection)ctx.getAttribute("mycon");  
		  
		//retieving data  from emp table
		PreparedStatement ps=con.prepareStatement("select * from emp",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=ps.executeQuery();
		out.print("<html><body>");
		out.print("<table border ='2'>");
		while(rs.next())
		{
			out.print("<tr>");
			out.print("<td>"+rs.getInt(1)+"</td>");
			out.print("<td>"+rs.getString(2)+"</td>");
			out.print("</tr>");
		}
		out.print("</table>");
		out.print("</html></body>");
		con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		out.close();  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}