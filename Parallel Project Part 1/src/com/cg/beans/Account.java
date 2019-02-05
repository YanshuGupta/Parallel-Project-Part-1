package com.cg.beans;

public class Account {
	private long accNum;
	private double balance;
	private Person accHolder;
	private AccountType accountType;
	
	public Account() {
		super();
	}

	public Account(long accNum, double balance, Person accHolder, AccountType accountType) {
		super();
		this.accNum = accNum;
		this.balance = balance;
		this.accHolder = accHolder;
		this.accountType = accountType;
	}
	
	public long getAccNum() {
		return accNum;
	}

	public void setAccNum(long accNum) {
		this.accNum = accNum;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Person getAccHolder() {
		return accHolder;
	}

	public void setAccHolder(Person accHolder) {
		this.accHolder = accHolder;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "Account [accNum=" + accNum + ", balance=" + balance + ", accHolder=" + accHolder + ", accountType="
				+ accountType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accHolder == null) ? 0 : accHolder.hashCode());
		result = prime * result + (int) (accNum ^ (accNum >>> 32));
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accHolder == null) {
			if (other.accHolder != null)
				return false;
		} else if (!accHolder.equals(other.accHolder))
			return false;
		if (accNum != other.accNum)
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		return true;
	}

	
	
}