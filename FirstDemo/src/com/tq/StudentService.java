package com.tq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tq.Student;
import com.tq.StudentDao;

public class StudentService {

	public static Connection getCon() {
		Connection con = null;
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			//Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/java_sqsl", "root", "root");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static int addStudent(Student s) {
		Connection con = null;
		int status = 0;
		try {
			con = getCon();
			status = StudentDao.addStudent(s, con);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return status;
	}

	public static ArrayList<Student> getStudents() {
		Connection con = null;
		ArrayList<Student> studentList = new ArrayList<Student>();
		// show alt shift r
		try {
			con = getCon();
			studentList = StudentDao.getStudents(con);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return studentList;
	}

}
