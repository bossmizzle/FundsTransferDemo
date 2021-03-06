package com.transferDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transferDemo.dao.IAccountDAO;
import com.transferDemo.entity.Account;
import com.transferDemo.entity.FundsTransferDetails;
@Service
public class AccountService implements IAccountService {
	
	@Autowired
	private IAccountDAO AccountDAO;
	
	/**
	*Method to retrieve an account details by the account number
	*@param account id
	*@return account details
	*/
	@Override
	public Account getAccountById(int AccountId) {
		Account obj = AccountDAO.getAccountById(AccountId);
		return obj;
	}	

	/**
	*Method to retrive all accounts created in the database
	*@return all account details
	*/
	@Override
	public List<Account> getAllAccounts(){
		return AccountDAO.getAllAccounts();
	}
	
	/**
	*Method to create a new account. Returns true if Account was successfully created
	*@param <object> Account details
	*@return <boolean>
	*/
	@Override
	public synchronized boolean addNewAccount(Account Account){
       if (AccountDAO.AccountExists(Account.getAccountId())) {
    	   return false;
       } else {
    	   AccountDAO.addNewAccount(Account);
    	   return true;
       }
	}
	
	/**
	*Method to transfer funds to a recipient account
	@param <object> FundsTransfer details
	*@return true if the funds transfer was succesful
	*/
	@Override
	public synchronized boolean transferFunds(FundsTransferDetails FundsTransferDetails)
	{
		boolean flag  = false;
		int senderAccountNo = FundsTransferDetails.getSenderAccount();
		
		int recipientAccountNo = FundsTransferDetails.getRecepientAccount();
		
		int transferAmount = FundsTransferDetails.getAmount();
		
		int senderAvailbleBalance = AccountDAO.getAccountById(senderAccountNo).getAccountBalance();
		
		int recipientAvailableBalance = AccountDAO.getAccountById(recipientAccountNo).getAccountBalance();
		
		//if both sender and recipient account id's exist
		if(AccountDAO.AccountExists(FundsTransferDetails.getSenderAccount()) &&
				AccountDAO.AccountExists(FundsTransferDetails.getRecepientAccount()))
			
		{	
			//check if sender has enough funds
			if(AccountDAO.hasSufficientFunds(senderAccountNo, transferAmount))
			{
				System.out.println("account holder has sufficient funds");
				//begin
				//debit the sender's account and update the remaining balance information
				int senderNewAccountBalance = senderAvailbleBalance - transferAmount;
				
				AccountDAO.updateAccountBalance(senderAccountNo, senderNewAccountBalance);
				
				//Now we credit the recipients account
				int recipientNewAccountBalance = recipientAvailableBalance + transferAmount;
				
				AccountDAO.updateAccountBalance(recipientAccountNo, recipientNewAccountBalance);
				
				flag = true;
			}
		}
		
		return flag;
	}
	
	
}
