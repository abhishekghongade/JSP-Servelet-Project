package com.jbk.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.jbk.dao.Dao;
import com.jbk.entity.Custinfo;

public class Service {

	Dao dao = new Dao();

	public ArrayList<Custinfo> getInfo() throws ClassNotFoundException, SQLException {

		return dao.getInfo();
	}

	public int insertInfo(String uname, String pass, String cpass, String email, String fname) {

		return dao.insertInfo(uname, pass, cpass, email, fname);

	}

	public int insertCustDetails(String fname, String lname, String email, String phone, String msg) {

		return dao.insertCustDetails(fname, lname, email, phone, msg);
	}

}
