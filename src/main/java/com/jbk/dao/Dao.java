package com.jbk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.jbk.config.Config;
import com.jbk.entity.Custinfo;

public class Dao {

	public ArrayList<Custinfo> getInfo() throws ClassNotFoundException, SQLException {

		Connection con = Config.getConnection();
		String query = "select * from custinfo";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Custinfo> al = new ArrayList<>();
		while (rs.next()) {
			String username = rs.getString("username");
			String password = rs.getString("password");

			Custinfo cs = new Custinfo();
			cs.setUsername(username);
			cs.setPassword(password);

			al.add(cs);
		}
		return al;
	}

	public int insertInfo(String uname, String pass, String cpass,String email,String fname) {

		Connection con = Config.getConnection();
		PreparedStatement ps;
		int isInserted = 0;
		try {
			ps = con.prepareStatement("insert into custinfo(username,password,confirmpass,email,fullname) values (?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, uname);
			ps.setString(2, pass);
			ps.setString(3, cpass);
			ps.setString(4, email);
			ps.setString(5, fname);
			isInserted = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("insert data error");
		}
		return isInserted;
	}

	public int insertCustDetails(String fname, String lname, String email, String phone, String msg) {
 
		Connection con = Config.getConnection();
		PreparedStatement ps;
		int isInserted = 0;
		try {
			ps = con.prepareStatement("insert into custdetails(fname,lname,email,phone,msg) values (?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, email);
			ps.setString(4, phone);
			ps.setString(5, msg);
			isInserted = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("insert data error");
		}
		return isInserted;
	}

}
