package com.transferDemo.dao;
import java.util.List;
import com.transferDemo.entity.Account;

/**The Account Database Access Object Interface
 * defines the features that need to be implemented in order to gain access to the database.
 * 
 * @author JBossman
 *
 */
public interface IAccountDAO {
    List<Account> getAllAccounts();
    int getAccountBalance(int AccountId);
    Account getAccountById(int AccountId);
    void addNewAccount(Account Account);
    void updateAccountBalance(int account_id, int new_balance);
    boolean hasSufficientFunds(int AccountId, int amount);
    //void deleteAccount(int AccountId);
    boolean AccountExists(int id);
}
 