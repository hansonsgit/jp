package com.bank.account.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.bank.account.to.BankAccount;
import com.bank.account.to.Provider;
import com.bank.account.to.response.ProviderStatus;
import com.bank.account.to.response.Response;

@Service
public class AccountService {
	@Value("${app.provider1.url}")
	private String urlProvider1;
	@Value("${app.provider2.url}")
	private String urlProvider2;

	public Response validate(BankAccount account) {

		List<String> inputProviders = account.getProviders();
		List<ProviderStatus> result = new ArrayList<ProviderStatus>();
		inputProviders.forEach(inputProvider -> result.add(
				new ProviderStatus(inputProvider, isValiddataProvider(inputProvider, account.getAccountNumber()))));
		Response response = new Response(result);
		return response;

	}


	private boolean isValiddataProvider(String inputProvider, String accountNumber) {
		if (inputProvider.equalsIgnoreCase("Provider1")) {
			isValid(urlProvider1, accountNumber);
		} else {
			isValid(urlProvider2, accountNumber);
		}
		return false;

	}

	private String isValid(String inputProvider, String accountNumber) {
		WebClient webClient = WebClient.create();
		MultiValueMap<String, String> bodyValues = new LinkedMultiValueMap<>();
		bodyValues.add("accountNumber", accountNumber);
		String provider = webClient.post()
				.uri(inputProvider)
				.header("Authorization", "Bearer MY_SECRET_TOKEN")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromFormData(bodyValues))
				.retrieve()
				.bodyToMono(String.class)
				.block();
		return provider;
	}

	public boolean validateProvider(Provider provider) {
		if ("12345678".equalsIgnoreCase(provider.getAccountNo())) {
			return true;
		}
		return false;
	
		
	}

}
