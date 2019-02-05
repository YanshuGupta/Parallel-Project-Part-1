package com.cg.service;

import java.util.HashMap;
import java.util.Map;

import com.cg.beans.Account;
import com.cg.beans.AccountType;
import com.cg.beans.Person;
import com.cg.exception.InsuffiecientBalanceException;
import com.cg.exception.InsuffiecientOpeningBalanceException;
import com.cg.exception.InvailidAccountNumberException;
import com.cg.exception.NegativeAmountException;
import com.cg.repo.AccountRepo;
import com.cg.repo.AccountRepoImpl;

public class AccountServiceImpl implements AccountService {
	
	private static AccountRepo accountRepo = new AccountRepoImpl();;
	
	
	/* (non-Javadoc)
	 * @see com.cg.service.AccountService#createAccount(long , double, java.lang.String, float, java.lang.String)
	 */
	
	
	public Account createAccount(long accountNumber, double initialBalance, String accountHolderName, float age, String accType) throws InsuffiecientOpeningBalanceException, InvailidAccountNumberException {
		
		if(initialBalance < 500) {
			throw new InsuffiecientOpeningBalanceException();
		}
		
		Person person = new Person(accountHolderName, age);
		AccountType accountType = new AccountType(accType);
		Account account = new Account(accountNumber, initialBalance, person, accountType);
		
		
		if(accountRepo.saveAccount(account)) {
			return account;
		}
		else {
			throw new InvailidAccountNumberException();
		}
	}



	/* (non-Javadoc)
	 * @see com.cg.service.AccountService#deposit(long, double)
	 */
	
	
	@Override
	public int deposit(long accountNumber, double balanceToAdd) throws InvailidAccountNumberException, NegativeAmountException {
		
		if(balanceToAdd < 0) {
			throw new NegativeAmountException();
		}
		
		Account account = accountRepo.searchAccount(accountNumber);
		if(account == null){
			throw new InvailidAccountNumberException();
		}
		
		account.setBalance(account.getBalance() + balanceToAdd);
		
		return (int)(account.getBalance());
	}
	
	
	
	
	/* (non-Javadoc)
	 * @see com.cg.service.AccountService#withdraw(long, double)
	 */
	
	
	@Override
	public int withdraw(long accountNumber, double balanceToWithdraw) throws InsuffiecientBalanceException, InvailidAccountNumberException, NegativeAmountException {
		
		if(balanceToWithdraw < 0) {
			throw new NegativeAmountException();
		}
		
		Account account = accountRepo.searchAccount(accountNumber);
		
		if(account == null) {
			throw new InvailidAccountNumberException();
		}
		
		if(account.getBalance() < balanceToWithdraw) {
			throw new InsuffiecientBalanceException();
		}
		
		account.setBalance(account.getBalance() - balanceToWithdraw);
		
		return (int) account.getBalance();
	}
	
	
	/* (non-Javadoc)
	 * @see com.cg.service.AccountService#FundTransfer(long, long, double)
	 */
	
	
	@Override
	public double FundTransfer(long senderAccountNumber, long receiverAccountNumber, double balanceToTransfer) throws InvailidAccountNumberException, InsuffiecientBalanceException,NegativeAmountException {
		
		if(balanceToTransfer < 0) {
			throw new NegativeAmountException();
		}
		
		Account sender = accountRepo.searchAccount(senderAccountNumber);
		Account receiver = accountRepo.searchAccount(receiverAccountNumber);
		
		if(sender == null || receiver == null) {
			throw new InvailidAccountNumberException();
		}
		
		if(sender.getBalance() < balanceToTransfer) {
			throw new InsuffiecientBalanceException();
		}
		
		else {
			sender.setBalance(sender.getBalance() - balanceToTransfer);
			receiver.setBalance(receiver.getBalance() + balanceToTransfer);
			
			return sender.getBalance();
		}
		
	}	
	
}