package com.bank.rudra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	public  Accbean ab=null;
	public Accbean login(String accno,String name) {
		Connection con=Dbcon.getconnection();
		try {
			PreparedStatement ps=con.prepareStatement("SELECT * FROM BANKACCOUNT WHERE ACCNO=? AND ACCHOLDERNAME=?");
			ps.setString(1,accno);
			ps.setString(2,name);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				ab=new Accbean();
				ab.setAccno(rs.getString(1));
				ab.setName(rs.getString(2));
				ab.setAmount(rs.getLong(3));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ab;
		
	}
}
