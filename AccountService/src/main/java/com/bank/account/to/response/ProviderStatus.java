package com.bank.account.to.response;

public class ProviderStatus {

	private String provider;
	private boolean isValid;

	public ProviderStatus(String provider, boolean isValid) {
		this.provider = provider;
		this.isValid = isValid;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

}
