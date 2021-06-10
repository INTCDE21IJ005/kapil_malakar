package com.cts.training.service;

import org.springframework.http.ResponseEntity;

import com.cts.training.exception.CustomerLoanNotFoundException;
import com.cts.training.exception.LoanApplicationNotFoundException;
import com.cts.training.exception.LoanNotFoundException;
import com.cts.training.model.CustomerLoan;
import com.cts.training.model.Loan_Application;
import com.cts.training.pojo.CashDeposit;
import com.cts.training.pojo.RealEstate;

/**
 * LoanManagementService Interface for the loan management functionality
 */
public interface LoanManagementService {
	/**
	 * For Fetching the loan details
	 * @param loanId
	 * @param customerId
	 * @return CustomerLoan
	 * @throws CustomerLoanNotFoundException
	 */
	public CustomerLoan getLoanDetails(int loanId,int custId) throws CustomerLoanNotFoundException;

	/**
	 * For Saving RealEstate Estate 
	 * @param token
	 * @param realEstate
	 * @return ResponseEntity/Status
	 * @throws CustomerLoanNotFoundException
	 * @throws LoanNotFoundException
	 */
	public ResponseEntity<String> saveRealEstate(String token, RealEstate realEstate)
			throws CustomerLoanNotFoundException, LoanNotFoundException;
	/**
	 * For Saving CashDeposit Estate
	 * @param token
	 * @param cashDeposit
	 * @return
	 * @throws CustomerLoanNotFoundException
	 * @throws LoanNotFoundException
	 */
	public ResponseEntity<String> saveCashDeposit(String token, CashDeposit cashDeposit)
			throws CustomerLoanNotFoundException, LoanNotFoundException;

	public Loan_Application applyLoan(Loan_Application loanApp);

	public Loan_Application getLoanApplicationStatus(int applicationId) throws LoanApplicationNotFoundException;

	public Loan_Application approveLoanApplication(String token, int loanAppId) throws LoanApplicationNotFoundException;

	public Loan_Application rejectLoanApplication(String token, int loanAppId) throws LoanApplicationNotFoundException;

	public Loan_Application getLoanApplicationStatus(String token, int loanAppId) throws LoanApplicationNotFoundException;
}
