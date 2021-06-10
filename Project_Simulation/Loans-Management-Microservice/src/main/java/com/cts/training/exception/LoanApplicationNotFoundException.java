package com.cts.training.exception;
/**
 * This is CustomerLoanNotFoundException 
 */
public class LoanApplicationNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * This is CustomerLoanNotFoundException constructor
	 * @param message
	 */
	public LoanApplicationNotFoundException(String message) {
		super(message);
	}

}
