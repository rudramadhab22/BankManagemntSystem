package com.bank.rudra;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbcon {
	private static Connection con=null;
	static {
		try {
			Class.forName(DBinfo.driver);
			con=DriverManager.getConnection(DBinfo.url,DBinfo.username,DBinfo.password);
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static Connection getconnection() {
		// TODO Auto-generated method stub
		return con;
	}

}
