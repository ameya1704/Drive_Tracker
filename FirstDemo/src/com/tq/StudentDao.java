package com.tq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tq.Student;
import com.tq.StudentProjConstants;
import com.tq.StudentService;

public class StudentDao {

	

	public static int addStudent(Student s, Connection con) {
		int status = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(StudentProjConstants.STR_STUD_INSERT);
			pstmt.setString(1, s.getSname());
			pstmt.setInt(2, s.getAge());
			status = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return status;
	}
	
	public int getSomething() {
		return 12;
	}

	public static ArrayList<Student> getStudents(Connection con) {
		ArrayList<Student> list = new ArrayList<Student>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			pstmt = con.prepareStatement(StudentProjConstants.STR_STUD_GETALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Student s = new Student();
				s.setStudentid(rs.getInt(1));
				s.setSname(rs.getString(2));
				s.setAge(rs.getInt(3));
				list.add(s);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				if(rs != null) {
					rs.close();
				}
				//pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}
