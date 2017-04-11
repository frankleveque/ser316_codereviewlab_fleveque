/*
  File:	Savings.java
  Author: ASU Staff
  Date:	4/10/17
  
  Description: Savings Account class that inherits from Account
*/


package banking.primitive.core;

/**
class: Savings	

Description: Implements a savings account
*/
public class Savings extends Account {
	private static final long serialVersionUID = 111L;

	public Savings(String name) {
		super(name);
	}

	public Savings(String name, float balance) throws IllegalArgumentException {
		super(name, balance);
	}
	
	
	/** 
	  Method: deposit
	  Inputs: amount
	  Returns: bool result indicating transaction successful

	  Description: A deposit comes with a fee of 50 cents per deposit
	*/
	public boolean deposit(float amount) {
		if (getState() != State.CLOSED && amount > 0.0f) {
			balance = balance + amount - 0.50F;
			if (balance >= 0.0f) {
				setState(State.OPEN);
			}
		}
		return false;
	}

	
	/** 
	  Method: withdraw
	  Inputs: amount
	  Returns: bool result indicating transaction successful

	  Description: A withdrawal. After 3 withdrawals a fee of $1 is added to each withdrawal.
	  An account whose balance dips below 0 is in an OVERDRAWN state
	*/
	public boolean withdraw(float amount) {
		if (getState() == State.OPEN && amount > 0.0f) {
			balance = balance - amount;
			numWithdraws++;
			if (numWithdraws > 3)
				balance = balance - 1.0f;
			// KG BVA: should be < 0
			if (balance <= 0.0f) {
				setState(State.OVERDRAWN);
			}
			return true;
		}
		return false;
	}

	public String getType() { return "Checking"; }

	public String toString() {
		return "Savings: " + getName() + ": " + getBalance();
	}
}
