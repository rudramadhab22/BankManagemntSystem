package com.bank.rudra;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class TransactionDao {
	public int k=0;
	
	public int transcation(long amount,String saccno,String raccno) {
		Connection con=Dbcon.getconnection();
		try {
			con.setAutoCommit(false);
			PreparedStatement ps=con.prepareStatement("UPDATE BANKACCOUNT SET ACCBALANCE=ACCBALANCE+? WHERE ACCNO=?");
			ps.setLong(1, amount);
			ps.setString(2, raccno);
			int a=ps.executeUpdate();
			
			PreparedStatement ps1=con.prepareStatement("UPDATE BANKACCOUNT SET ACCBALANCE=ACCBALANCE-? WHERE ACCNO=?");
			ps1.setLong(1, amount);
			ps1.setString(2, saccno);
			int b=ps1.executeUpdate();
			
			PreparedStatement ps2=con.prepareStatement("INSERT INTO transaction VALUES(?,?,?)");
			SecureRandom secureRandom = new SecureRandom();
	        int randomNumber = 10000 + secureRandom.nextInt(90000);
	        ps2.setString(1,String.valueOf(randomNumber));
	        LocalDateTime ld=LocalDateTime.now();
	        ps2.setString(2,String.valueOf(ld));
	        ps2.setLong(3,amount);
	        int c=ps2.executeUpdate();
	        if(a==1&&b==1&&c==1) {
	        	con.commit();
	        	k=1;
	        }
	        else {
	        	con.rollback();
	        }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k;
		
	}
	
	
}
