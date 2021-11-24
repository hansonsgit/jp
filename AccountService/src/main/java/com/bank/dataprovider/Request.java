package com.bank.dataprovider;

public class Request {
	private String accountNumber;
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	@Override
	public String toString() {
		return "Provider [accountNumber=" + accountNumber + "]";
	}
}
