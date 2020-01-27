package Priyanka_Mam_Project;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String requestData = request.getReader().readLine();
		

		User u = (User) UtilityJson.getObjectFromJSON(requestData, User.class);
		

		Map<String, String> map = DaoLayer.updateData(u);

		String responseData = (String) UtilityJson.getJSONFromObject(map);
		
		response.getWriter().write(responseData);
		
		response.flushBuffer();

	}

}
