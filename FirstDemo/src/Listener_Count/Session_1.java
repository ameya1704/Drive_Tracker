package Listener_Count;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class Session_1 implements HttpSessionListener
{
	static int current =0;
	static int total=0;
	ServletContext ctx =null;
    public Session_1(){}
    public void sessionCreated(HttpSessionEvent e)
    {
       total++;  
        current++;    
        ctx=e.getSession().getServletContext();
        ctx.setAttribute("totalusers", total);
        ctx.setAttribute("currentusers", current);
    }

    public void sessionDestroyed(HttpSessionEvent se)
    {
        current--;
        ctx.setAttribute("currentusers",current);
    }	
}