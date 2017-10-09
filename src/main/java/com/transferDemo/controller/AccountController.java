package com.transferDemo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.transferDemo.entity.Account;
import com.transferDemo.entity.FundsTransferDetails;
import com.transferDemo.service.IAccountService;

@Controller
@RequestMapping("user")
public class AccountController {
	@Autowired
	private IAccountService AccountService;
	@GetMapping("Account/{id}")
	public ResponseEntity<Account> getAccountBalance(@PathVariable("id") Integer id) {
		Account Account = AccountService.getAccountById(id);
		return new ResponseEntity<Account>(Account, HttpStatus.OK);
	}
	
	@GetMapping("Account")
	public ResponseEntity<List<Account>> getAllAccounts() {
		List<Account> list = AccountService.getAllAccounts();
		return new ResponseEntity<List<Account>>(list, HttpStatus.OK);
	}
	
	/**Creates a new Account Holder
	 * 
	 * @param Account
	 * @param builder
	 * @return
	 */
	@PostMapping("Account/create")
	public ResponseEntity<Void> addNewAccount(@RequestBody Account Account, UriComponentsBuilder builder) {
        boolean flag = AccountService.addNewAccount(Account);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/Account/create").buildAndExpand(Account.getAccountId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	/**Transfers funds from a sender to a recipient account number
	 * 
	 * @param TransferDeetails
	 * @param builder
	 * @return
	 */
	@PostMapping("Account/transfer")
	public ResponseEntity<Void> transferFunds(@RequestBody FundsTransferDetails FundsTransferDetails, UriComponentsBuilder builder){
		boolean flag = AccountService.transferFunds(FundsTransferDetails);
		if(flag==false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/Account/transfer").build().toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	

} 