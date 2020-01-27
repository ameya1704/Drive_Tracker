package Priyanka_Mam_Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DaoLayer {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection con = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crudtable?useSSL=false", "root", "root");
		return con;
	}

	public static Map<String, String> saveData(User u) throws ClassNotFoundException, SQLException {

		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement("insert into employee(name,email,password,mobile) values(?,?,?,?)");

		String name = u.getName();
		String email = u.getEmail();
		String password = u.getPassword();
		long mobno = u.getMobno();

		ps.setObject(1, name);
		ps.setObject(2, email);
		ps.setObject(3, password);
		ps.setObject(4, mobno);

		int status = ps.executeUpdate();

		Map<String, String> map = new HashMap<>();

		if (status == 1) {
			map.put("msg", "done");

		} else {
			map.put("msg", "sorry");
		}
		return map;
	}

	public static ArrayList<User> getUserDataFromDB() throws ClassNotFoundException, SQLException {

		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement("select * from employee");

		ResultSet rs = ps.executeQuery();

		ArrayList<User> list = new ArrayList<>();

		while (rs.next()) {
			User u = new User();
			u.setId(rs.getInt(1));
			u.setName(rs.getString(2));
			u.setEmail(rs.getString(3));
			u.setPassword(rs.getString(4));
			u.setMobno(rs.getLong(5));

			list.add(u);
		}
		return list;
	}

	public static Map<String, String> deleteEmpData(User u) throws ClassNotFoundException, SQLException {
		
		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement("delete from employee where id=?");

		ps.setObject(1, u.getId());

		int status = ps.executeUpdate();

		Map<String, String> mp = new HashMap<>();

		if (status == 1) {
			mp.put("msg", "done");
		} else {
			mp.put("msg", "sorry");
		}

		return mp;

	}

	public static Map<String, String> updateData(User u) {

		Map<String, String> map=new HashMap<String, String>();
		
		try {
			Connection con = getConnection();

			PreparedStatement ps = con.prepareStatement("update employee set name=?,email=?,password=?,mobile=? where id=?");

			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			ps.setLong(4, u.getMobno());
			ps.setInt(5, u.getId());

			int status = ps.executeUpdate();

			if (status == 1)
			{
				map.put("msg", "done");
			}
			else
			{
				map.put("msg", "sorry");
			}

		} 
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return map;

	}

}