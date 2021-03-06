package Priyanka_Mam_Project;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String requestdata = request.getReader().readLine();

		User u = (User) UtilityJson.getObjectFromJSON(requestdata, User.class);

		Map<String, String> map = null;
		try
		{
			map = DaoLayer.saveData(u);
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
		String responsedata = (String) UtilityJson.getJSONFromObject(map);
		
		response.getWriter().write(responsedata);
		
		response.flushBuffer();
	}

}
