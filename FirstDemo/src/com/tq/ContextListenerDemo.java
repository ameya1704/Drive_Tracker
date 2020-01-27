package com.tq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ContextListenerDemo
 *
 */
@WebListener
public class ContextListenerDemo implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ContextListenerDemo() {
        // TODO Auto-generated constructor stub
    	
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event)  { 
         // TODO Auto-generated method stub
    	System.out.println(" context is destroyed ");
    	ServletContext ctx = event.getServletContext(); 
		Connection con = (Connection) ctx.getAttribute("myConnection");
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
         // TODO Auto-generated method stub
    	System.out.println(" context is initialized ");
    }
	
}
