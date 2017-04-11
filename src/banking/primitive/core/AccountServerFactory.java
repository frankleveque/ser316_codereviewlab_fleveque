/*
  File:	AccountServerFactory.java
  Author: ASU Staff
  Date:	4/10/17
  
  Description: singleton that creates server solutions
*/


package banking.primitive.core;

/**
Interface: AccountServerFactory	

Description: Singleton class that provides ServerSolution
*/
public class AccountServerFactory {

	protected static AccountServerFactory singleton = null;

	protected AccountServerFactory() {

	}

	public static AccountServerFactory getMe() {
		if (singleton == null) {
			singleton = new AccountServerFactory();
		}

		return singleton;
	}

	/**
	  Method: lookup
	  Inputs: void
	  Returns: AccountServer

	  Description: returns new instance of ServerSolution - should probably be refactored
	*/
	public AccountServer lookup() {
		return new ServerSolution();
	}
}
