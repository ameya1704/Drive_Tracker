package Validation_Login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Validation")
public class Validation extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
			response.setContentType("text/html");
			String validname ="Ameya";
			String validpass="ameya1999";
			PrintWriter pw = response.getWriter();
			String uname = request.getParameter("user");
			String pass = request.getParameter("pass");
			if(validname.equals(uname) && validpass.equals(pass))
			{
				RequestDispatcher dis = request.getRequestDispatcher("Welcome "+uname+" !!");
				dis.forward(request, response);
			}
			else
			{
				pw.print("User name of password  is invalid !!!");
				RequestDispatcher dis = request.getRequestDispatcher("index.html");
				dis.include(request, response);
			}
	}
}