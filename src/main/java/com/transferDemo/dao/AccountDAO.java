package com.transferDemo.dao;



import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.transferDemo.entity.Account;

/**The AccountDAO or Account Data Access Object class
 * defines how data will be retrieved from the Database.
 * 
 * @author JBossman
 *
 */
@Transactional
@Repository
public class AccountDAO implements IAccountDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Account getAccountById(int AccountId) {
		return entityManager.find(Account.class, AccountId);
	}
	
	/**Method returns all accounts that have been created
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Account> getAllAccounts() {
		String hql = "FROM Account as atcl ORDER BY accountId";
		return (List<Account>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addNewAccount(Account Account) {
		entityManager.persist(Account);
	}
	
	
	@Override
	/**Method to Update the account balance 
	 */
	public void updateAccountBalance(int account_id,  int new_balance) {
		Account artcl = getAccountById(account_id);
		artcl.setAccountBalance(new_balance);
		entityManager.flush();
	}
	
	
	@Override
	/**Method to retrieve the account balance based on the account id
	 * 
	 * @param <int> the accountId
	 * @return <int> the account Balance
	 */
	public int getAccountBalance(int accountId) {
		// TODO Auto-generated method stub
		
		return entityManager.find(Account.class, accountId).getAccountBalance();
	}
	
	
	@Override
	/**Method to check if account exists before creating new user account
	 * 
	 * @return true if account exists
	 */
	public boolean AccountExists(int id) {
		int count = entityManager.find(Account.class, id).getAccountId();
		return count > 0 ? true : false;
	}
	
	/**Method to check if account holder has insufficient funds
	 * 
	 * @return true if account holder has insufficient funds
	 */
	@Override
	public boolean hasSufficientFunds(int accountId, int transfer_amount) {
		boolean hasFunds = true;
		// TODO Auto-generated method stub
		int available_balance = getAccountById(accountId).getAccountBalance();
		if(transfer_amount>available_balance)
		{
			hasFunds = false;
		}
		return hasFunds;
		
	}
}
