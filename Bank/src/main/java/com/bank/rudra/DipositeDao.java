package com.bank.rudra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;





public class DipositeDao {
	
	public int k=0;
	public int diposite(long amount,String acno) {
		
		Connection con=Dbcon.getconnection();
		
		try {
			PreparedStatement ps=con.prepareStatement("update BANKACCOUNT set  ACCBALANCE=ACCBALANCE+? where ACCNO=? ");
			ps.setLong(1, amount);
			ps.setString(2,acno);
			k=ps.executeUpdate();
			//System.out.println(ab.getAccno());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		return k;
		
	}

}
