package com.tq;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Db_Conn implements ServletContextListener
{

	public Db_Conn()
	{}
	
    public void contextDestroyed(ServletContextEvent sce){}
    
    public void contextInitialized(ServletContextEvent event) 
    {
    	try
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/user","root","root");
    		ServletContext ctx=event.getServletContext();
    		ctx.setAttribute("mycon", con);
    		System.out.println(con);
   		}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
}