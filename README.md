# FundsTransferDemo
Demo REST API 

--------------------
Stack employed
--------------------
Database: Mysql    {Easier to use - opensource}
SpringBoot Framwork {i preferred this because it is quite fast and easy to deploy}
Jersey,Jax-RS  {It is light weight and simple to use}
Apache-Tomcat5 {Apache-Tomcat8.5 because i find it easier to work with)
Java Data Persistence API {To allow imporoved data access to the db}

--------------------
SOLUTION
--------------------
The demonstration required me to build a RESTFUL API that mimicks a Funds Transfer
In order to have a successful funds transfer the below is i implemented.
1. A light weight middleware to act as the businessLogic layer
2. A url endpoints that allow the user to	
	a. create a new user account    POST - http://localhost:8080/FundsTransferDemo/user/Account/create
	b. view all account holders     GET - http://localhost:8080/FundsTransferDemo/user/Account
	c. view account by account id   GET - http://localhost:8080/FundsTransferDemo/user/Account/{id}
	d. send a funds transfer        POST-  http://localhost/8080/FundsTransferDemo/user/Account/transfer
	
The flow i used for the funds transfer is as follows
For an account transfer to be successful the below conditions must be satisfied
1. Both account holders must exist in the database i.e (The sender and the recipient)
2. The account holder must have sufficient balance for the transaction (the account balance cannot be overdrawn)
3. When the transfer is done, the account of the sender should be debited and the account of the recipient should be credited.

i also added a few utility methods to handle the debit and credit updates to the database records.

1. hasSufficientFunds - > This methods determins whether an account holder has enough funds to transfer
2. doesAccountExist	  - > This mehtod also determines whether an account holder exists.

When these conditions are satisfied, 
the the transactions is allowed to be processed.

