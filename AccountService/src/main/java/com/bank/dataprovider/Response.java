package com.bank.dataprovider;

import java.util.List;

import com.bank.account.to.response.ProviderStatus;

public class Response {

	private List<ProviderStatus> result = null;
	public Response(List<ProviderStatus> result) {
		this.result = result;
	}
	public List<ProviderStatus> getResult() {
		return result;
	}
	public void setResult(List<ProviderStatus> result) {
		this.result = result;
	}

}
