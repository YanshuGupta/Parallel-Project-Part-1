package com.cg.repo;

import com.cg.beans.Account;
import com.cg.exception.InvailidAccountNumberException;

public interface AccountRepo {

	boolean saveAccount(Account account);

	Account searchAccount(long accountNumber);


}