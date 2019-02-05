package com.cg.view;

import com.cg.exception.InsuffiecientBalanceException;
import com.cg.exception.InsuffiecientOpeningBalanceException;
import com.cg.exception.InvailidAccountNumberException;
import com.cg.exception.NegativeAmountException;
import com.cg.repo.AccountRepoImpl;
import com.cg.service.AccountService;
import com.cg.service.AccountServiceImpl;

public class Client {

	public static void main(String[] args) {
		
		AccountService handle = new AccountServiceImpl();
		try {
			handle.createAccount(100, 4000, "YANSHU GUPTA", 22, "SAVING");
			handle.createAccount(100, 4000, "YANSHU GUPTA", 22, "SAVING");
			handle.deposit(100, 500);
			handle.withdraw(100, 500);
		} catch (InsuffiecientOpeningBalanceException e) {
			System.out.println("InsuffiecientOpeningBalanceException");
		} catch (InvailidAccountNumberException e) {
			System.out.println("InvailidAccountNumberException");
		} catch (NegativeAmountException e) {
			System.out.println("Negative Amount");
		} catch (InsuffiecientBalanceException e) {
			System.out.println("InsuffiecientBalanceException");

		}

	}

}
