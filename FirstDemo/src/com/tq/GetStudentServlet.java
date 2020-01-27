package com.tq;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tq.Student;
import com.tq.StudentDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tq.StudentService;

/**
 * Servlet implementation class GetStudentServlet
 */
@WebServlet("/GetStudents")
public class GetStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Student> list = (ArrayList<Student>) StudentService.getStudents();
		Map<String, Object> mapObject = new HashMap<String, Object>();
		 mapObject.put("students", list);
		 mapObject.put("status", true);
		 //response.addHeader("Access-Control-Allow-Origin", "*");
		 includeJSONResponse(mapObject, request, response);
		 
		
	}
	
	public void includeJSONResponse(Map<String, Object> jsonMap, HttpServletRequest request, HttpServletResponse response) {
		String jsonString = getValidJsonFromObject(jsonMap);
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");

			System.out.println("before write :: " + response.isCommitted());
			response.getWriter().write(jsonString);
			
			
			System.out.println("jsonString :: " + jsonString);
			
		} catch (Exception e) {
			
			System.err.println("Error in  includeJSONResponse");
		}
	}
	
	public String getJSONFromObject(Object object) {
		String jsonData = null;
		 ObjectMapper writeMapper = new ObjectMapper();
		try {
			// {"students":[{"studentid":2,"sname":"amit","age":27},{"studentid":3,"sname":"balaji","age":29}],"status":true}
		    jsonData = writeMapper.writeValueAsString(object);
		} catch (Exception e) {
			System.err.println("Error in  getJSONFromObject ");
		}
		return jsonData;
	}

	
	public String getValidJsonFromObject(Map<String, Object> allObjectMap) {
		if (null == allObjectMap || allObjectMap.isEmpty()) {
		    
			allObjectMap = new HashMap<String, Object>();
			
		}
		return getJSONFromObject(allObjectMap);
	}
	
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
