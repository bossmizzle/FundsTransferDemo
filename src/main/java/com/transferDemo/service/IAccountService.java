package com.transferDemo.service;

import java.util.List;

import com.transferDemo.entity.Account;
import com.transferDemo.entity.FundsTransferDetails;

public interface IAccountService {
     List<Account> getAllAccounts();
     Account getAccountById(int AccountId);
     //Account getAccountBalance(int AccountId);
     boolean addNewAccount(Account Account);
    
     boolean transferFunds(FundsTransferDetails FundsTransferDetails);
  
}
