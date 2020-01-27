package Listener_Count;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/First")
public class First extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public First()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
      
        String n=request.getParameter("username");  
        out.print("Welcome "+n);          
        HttpSession session=request.getSession();  
      //  session.setAttribute("uname",n);  
        
        System.out.println(session);
        ServletContext ctx=getServletContext();  
        int t=(Integer)ctx.getAttribute("totalusers");  
        int c=(Integer)ctx.getAttribute("currentusers");  
        out.print("<br>total users= "+t);  
        out.print("<br>current users= "+c);  

        out.print("<br><a href='LogoutServlet'>logout</a>");  

        out.close();  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}