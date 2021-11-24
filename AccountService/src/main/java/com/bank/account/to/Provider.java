package com.bank.account.to;

public class Provider {
	private String accountNumber;
	
	public Provider(String accountNumber) {
		this.accountNumber = accountNumber;
	
	}
	public String getAccountNo() {
		return accountNumber;
	}

	public void setAccountNo(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	@Override
	public String toString() {
		return "Provider [accountNumber="  + accountNumber + "]";
	}





	
}
