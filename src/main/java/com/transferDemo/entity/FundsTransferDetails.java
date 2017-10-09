package com.transferDemo.entity;

import java.io.Serializable;

import javax.persistence.Entity;

/**The Transfer Details Class defines the properties of a funds transfer.
 * In a typical situation we would need the sender and recipient account numbers
 * and the amount being transferred.
 * 
 * @author JBossman
 *
 */

public class FundsTransferDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1036884379944694381L;
	private int senderAccount;
	private int amount;
	private int recepientAccount;
	
	/**Return sender's account number
	 * 
	 * @return <int> account number
	 */
	public int getSenderAccount() {
		return senderAccount;
	}
	
	/**Set Sender's account number
	 * 
	 * @param senderAccount
	 */
	public void setSenderAccount(int senderAccount) {
		this.senderAccount = senderAccount;
	}
	
	/**Return the amount being transferred
	 * 
	 * @return <int> amount
	 */
	public int getAmount() {
		return amount;
	}
	
	/**Set the sender amount
	 * 
	 * @param senderAmount
	 */
	public void setSenderAmount(int amount) {
		this.amount = amount;
	}
	
	/**Get the recipient's account number
	 * 
	 * @return <int> recipient account
	 */
	public int getRecepientAccount() {
		return recepientAccount;
	}
	
	/**Set the recipient's account
	 * 
	 * @param recepientAccount
	 */
	public void setRecepientAccount(int recepientAccount) {
		this.recepientAccount = recepientAccount;
	}
	
	
}
