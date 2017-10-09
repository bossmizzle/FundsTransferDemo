package com.transferDemo.client;

import java.net.URI;

import org.junit.runner.JUnitCore;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;


import com.transferDemo.entity.Account;
import com.transferDemo.entity.FundsTransferDetails;

public class RestClientUtil extends JUnitCore{
	
	@Test
    public void getAccountByIdDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/Account/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Account> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Account.class, 1);
        Account Account = responseEntity.getBody();
        System.out.println("Id:"+Account.getAccountId()+", Title:"+Account.getAccountName()
                 +", Category:"+Account.getAccountBalance());      
    }
    
    @Test
	public void getAllAccountsDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/Accounts";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Account[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Account[].class);
        Account[] Accounts = responseEntity.getBody();
        for(Account Account : Accounts) {
              System.out.println("Id:"+Account.getAccountId()+", Title:"+Account.getAccountName()
                      +", Category: "+Account.getAccountBalance());
        }
    }
	
	@Test
    public void addAccountDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/Account/create";
	    Account objAccount = new Account();
	    objAccount.setAccountId(5);
	    objAccount.setAccountName("Guilia");
	    objAccount.setAccountBalance(500);
        HttpEntity<Account> requestEntity = new HttpEntity<Account>(objAccount, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    
    
    @Test
    public void transferFundsDemo()
    {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/Account/transfer";
	    FundsTransferDetails fundstransfer = new FundsTransferDetails();
	    fundstransfer.setSenderAccount(5);
	    fundstransfer.setSenderAmount(100);
	    fundstransfer.setRecepientAccount(1);
        HttpEntity<FundsTransferDetails> requestEntity = new HttpEntity<FundsTransferDetails>(fundstransfer, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
  
    
    public static void main(String args[]) {
    	RestClientUtil util = new RestClientUtil();
        util.getAccountByIdDemo();
    	util.getAllAccountsDemo();
    	util.addAccountDemo();
    	util.transferFundsDemo();
    }    
    
   
    
}
