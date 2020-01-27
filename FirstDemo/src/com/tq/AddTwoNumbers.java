package com.tq;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Addition")

public class AddTwoNumbers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTwoNumbers()
    {
        super();
    }

    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Table Example</title></head>");
        out.println("<body>");
        out.println("<h3>Add Two Numbers</h3>");
        out.println("<form method='post' action='Addition'>");
        out.println("<p>Enter First Number: <input type='text' name='first'></p>");
        out.println("<p>Enter Second Number: <input type='text' name='second'></p>");
        out.println("<p><input type='submit' value='submit'></p>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
    {
        String a = request.getParameter("first");
        String b = request.getParameter("second");


        int sum = Integer.parseInt(a) + Integer.parseInt(b);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Add</title></head><body>");

        out.println("<p>The sum of " + a + " and "
                + b + " is " + sum + ".</p>");

        out.println("</body></html>");
    }
}