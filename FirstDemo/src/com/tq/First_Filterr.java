package com.tq;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class First_Filterr
 */
//	@WebFilter("/First_Fil")
public class First_Filterr implements Filter
{
    /**
     * Default constructor. 
     */
    public First_Filterr() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		    PrintWriter out=response.getWriter();  
		    out.println("filter is invoked before f1"); 
		    System.out.println("before....");
			chain.doFilter(request, response);
			 out.println("filter is invoked after f1");
			 System.out.println("After...");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException
	{
	}
}