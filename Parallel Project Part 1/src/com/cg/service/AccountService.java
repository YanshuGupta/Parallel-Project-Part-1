package com.cg.service;

import java.util.Map;

import com.cg.beans.Account;
import com.cg.exception.InsuffiecientBalanceException;
import com.cg.exception.InsuffiecientOpeningBalanceException;
import com.cg.exception.InvailidAccountNumberException;
import com.cg.exception.NegativeAmountException;

public interface AccountService {

	Account createAccount(long accountNumber, double initialBalance, String accountHolderName, float age, String accType)
			throws InsuffiecientOpeningBalanceException, InvailidAccountNumberException;

	int deposit(long accountNumber, double balanceToAdd) throws InvailidAccountNumberException, NegativeAmountException;

	int withdraw(long accountNumber, double balanceToWithdraw)
			throws InsuffiecientBalanceException, InvailidAccountNumberException, NegativeAmountException;

	double FundTransfer(long senderAccountNumber, long receiverAccountNumber, double balanceToTransfer)
			throws InvailidAccountNumberException, InsuffiecientBalanceException, NegativeAmountException;

	
}