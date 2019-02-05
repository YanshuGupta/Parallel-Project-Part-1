package com.cg.repo;

import java.util.HashMap;
import java.util.Map;

import com.cg.beans.Account;
import com.cg.beans.AccountType;
import com.cg.beans.Person;
import com.cg.exception.InvailidAccountNumberException;

public class AccountRepoImpl implements AccountRepo {

	private static Map<Long, Account> accounts = new HashMap<>();
	
	
	/* (non-Javadoc)
	 * @see com.cg.repo.AccountRepo#saveAccount(com.cg.beans.Account)
	 */
	
	@Override
	public boolean saveAccount(Account account) {
	
		if(accounts.containsKey(account.getAccNum())) {
			return false;	//Account is already exist
		}
		else {
			accounts.put(account.getAccNum(),account);
			return true;
		}		
	}
	
	
	
	
	
	/* (non-Javadoc)
	 * @see com.cg.repo.AccountRepo#showAccount(long)
	 */
	
	
	@Override
	public Account searchAccount(long accountNumber){
			
		if(accounts.containsKey(accountNumber)) {
			
			Account account = accounts.get(accountNumber);
			return account;
		}
		else {	
			return null;
		}
	}
}












/*Person person = account.getAccHolder();
AccountType accountType = account.getAccountType();
return  "Account Number : " + account.getAccNum() + '\n' +
		"Account Holder Name : " + person.getName() + '\n' +
		"Account Balance : " + account.getBalance() + '\n' +
		"Account Type : " + accountType.getAccountType() + '\n' +
		"Account Holder Age : " + person.getAge() + '\n' ;
*/