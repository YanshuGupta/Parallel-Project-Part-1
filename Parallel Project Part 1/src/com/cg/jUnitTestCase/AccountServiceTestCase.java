package com.cg.jUnitTestCase;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.beans.Account;
import com.cg.beans.AccountType;
import com.cg.beans.Person;
import com.cg.exception.InsuffiecientBalanceException;
import com.cg.exception.InsuffiecientOpeningBalanceException;
import com.cg.exception.InvailidAccountNumberException;
import com.cg.exception.NegativeAmountException;
import com.cg.repo.AccountRepo;
import com.cg.service.AccountService;
import com.cg.service.AccountServiceImpl;

public class AccountServiceTestCase {

	@Mock
	AccountService accountService;
	
	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		
		accountService = new AccountServiceImpl();
	}
	//when(accountRepo.saveAccount(account)).thenReturn(true);


	
	/*
	 * create account
	 * 1.when the amount is less than 500 then system should throw exception
	 * 2.when the valid info is passed account should be created successfully
	 */
	
	
	@Test(expected = InsuffiecientOpeningBalanceException.class)
	public void whenTheAmountIsLessThan500SystemShouldThrowException() throws InsuffiecientOpeningBalanceException, InvailidAccountNumberException {
		accountService.createAccount(100, 400, "YANSHU", 22, "SAVING ACCOUNT");
	}
	
	
	@Test
	public void whenTheValidInfoIsPassedAccountShouldBeCreatedSuccessfully() throws InsuffiecientOpeningBalanceException, InvailidAccountNumberException {
		accountService.createAccount(100, 4000, "YANSHU", 22, "SAVING ACCOUNT");
	}
	
	
	/*
	 * 1.Deposit Amount in the non Existing Account Number..........
	 * 2.Deposit Negative Amount
	 * 3.Deposit Amount successfully
	 */
	
	@Test(expected = InvailidAccountNumberException.class)
	public void whenAccountNumberIsNotExistAndTryToDepositMoney() throws InvailidAccountNumberException, InsuffiecientOpeningBalanceException, NegativeAmountException{
		
		accountService.deposit(101, 500);
	}
	
	@Test(expected = NegativeAmountException.class)
	public void whenNegativeAmoutIsDeposit() throws InvailidAccountNumberException, InsuffiecientOpeningBalanceException, NegativeAmountException{
		accountService.deposit(101, -500);
	}
	
	@Test
	public void whenDepositAmountSuccessfully() throws InvailidAccountNumberException, InsuffiecientOpeningBalanceException, NegativeAmountException{
		accountService.createAccount(102, 4000, "YANSHU", 22, "SAVING ACCOUNT");
		assertEquals(4500, accountService.deposit(102, 500));	
	}
	
	
	/*
	 * 1.WithDraw Amount in the non Existing Account Number
	 * 2.WithDraw Negative Amount
	 * 3.WithDraw amount is more than current balance
	 * 4.WithDraw Amount Successfully
	 */
	
	@Test(expected = InvailidAccountNumberException.class)
	public void whenAccountNumberIsNotExistAndTryToWithdrawMoney() throws InvailidAccountNumberException, InsuffiecientOpeningBalanceException, NegativeAmountException, InsuffiecientBalanceException{
		accountService.withdraw(103, 500);
	}
	
	@Test(expected = NegativeAmountException.class)
	public void whenNegativeAmoutIsWithDraw() throws InvailidAccountNumberException, InsuffiecientOpeningBalanceException, NegativeAmountException, InsuffiecientBalanceException{
		accountService.withdraw(101, -500);
	}
	
	@Test(expected = InsuffiecientBalanceException.class)
	public void whenWithdrawAmountIsMoreThanCurrentBalance() throws InvailidAccountNumberException, InsuffiecientOpeningBalanceException, NegativeAmountException, InsuffiecientBalanceException{
		accountService.createAccount(107, 4000, "YANSHU", 22, "SAVING ACCOUNT");
		accountService.withdraw(107, 4500);
	}
	
	@Test
	public void whenWithdrawAmountSuccessfully() throws InvailidAccountNumberException, InsuffiecientOpeningBalanceException, NegativeAmountException, InsuffiecientBalanceException{
		accountService.createAccount(111, 4000, "YANSHU", 22, "SAVING ACCOUNT");
		assertEquals(3500, accountService.withdraw(111, 500));	
	}
}


