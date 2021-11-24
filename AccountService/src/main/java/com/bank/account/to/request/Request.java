package com.bank.account.to.request;

import java.util.List;



public class Request {
	private String accountNumber;
	private List<String> providers;
	public Request(String accountNumber,List<String> providers) {
		this.accountNumber = accountNumber;
		this.providers=providers;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public List<String> getProviders() {
		return providers;
	}
	public void setProviders(List<String> providers) {
		this.providers = providers;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", providers=" + providers + "]";
	}
	
}
