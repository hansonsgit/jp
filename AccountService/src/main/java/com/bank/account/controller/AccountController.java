package com.bank.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bank.account.service.AccountService;
import com.bank.account.to.BankAccount;
import com.bank.account.to.Provider;
import com.bank.account.to.response.Response;

@RestController
public class AccountController {
	@Autowired
	private AccountService accountService;


	@RequestMapping(value = "/accounts/validate", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseStatus(HttpStatus.OK)
	public Response isAccountValid(@RequestBody BankAccount account) {

		return accountService.validate(account);
	}
	
	@RequestMapping(value = "/accounts/dataprovider", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseStatus(HttpStatus.OK)
	public boolean validateProvider(@RequestBody Provider provider) {
		return accountService.validateProvider(provider);
	}

}
