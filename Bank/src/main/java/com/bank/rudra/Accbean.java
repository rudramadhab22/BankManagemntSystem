package com.bank.rudra;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Accbean implements Serializable {
	private String accno;
	private String name;
	private long amount;
	
	public String getAccno() {
		return accno;
	}

	public void setAccno(String accno) {
		this.accno = accno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Accbean() {
		
	}
	

}
