package com.cts.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.training.exception.CollateralTypeNotFoundException;
import com.cts.training.exception.CustomerLoanNotFoundException;
import com.cts.training.exception.LoanApplicationNotFoundException;
import com.cts.training.exception.LoanNotFoundException;
import com.cts.training.feign.CollateralFeign;
import com.cts.training.model.CustomerLoan;
import com.cts.training.model.Loan;
import com.cts.training.model.Loan_Application;
import com.cts.training.pojo.CashDeposit;
import com.cts.training.pojo.RealEstate;
import com.cts.training.repo.CustomerLoanRepo;
import com.cts.training.repo.LoanApplicationRepo;
import com.cts.training.repo.LoanRepo;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

/**
 * LoanManagementService implementation
 */

@Service
@Slf4j
public class LoanManagementServiceImpl implements LoanManagementService {

	@Autowired
	private CollateralFeign client;

	@Autowired
	private CustomerLoanRepo customerLoanRepo;

	@Autowired
	private LoanRepo loanRepo;

	@Autowired
	private LoanApplicationRepo loanAppRepo;

	private static final String MESSAGE = "Customer Loan Not found with LoanId: ";

	private static final Logger log = LoggerFactory.getLogger(LoanManagementServiceImpl.class);

	/**
	 * Get Loan Details Implimentation
	 */
	@Override
	public CustomerLoan getLoanDetails(int loanId,int custId) throws CustomerLoanNotFoundException {
		log.info("Get Loan details using loan id and customer id");
		log.info(loanId + "=======" );
		System.out.println("Inside loan management service================");
		CustomerLoan customerLoan = customerLoanRepo.findById(loanId)
				.orElseThrow(() -> new CustomerLoanNotFoundException(MESSAGE + loanId));
		/*
		 * Optional<CustomerLoan> customerLoan=customerLoanRepo.findById(loanId);
		 * System.out.println(customerLoan.get()); if(!customerLoan.isPresent()) { throw
		 * new CustomerLoanNotFoundException(MESSAGE+loanId); }
		 */
		System.out.println(customerLoan);
		if(customerLoan.getCustomerId()!=custId) {
			new CustomerLoanNotFoundException(MESSAGE + loanId);
		}
		return customerLoan;
	}

	/**
	 * Save RealEstate Implementatiom
	 * 
	 * @throws LoanNotFoundException
	 */
	@Override
	public ResponseEntity<String> saveRealEstate(String token, RealEstate realEstate)
			throws CustomerLoanNotFoundException, LoanNotFoundException {
		log.info("Save Real Estate collateral details");
		System.out.println(
				"===========Saving Real Estate details============= from loan management service" + realEstate);
		CustomerLoan customerLoan = customerLoanRepo.findById(realEstate.getLoanId())
				.orElseThrow(() -> new CustomerLoanNotFoundException(MESSAGE + realEstate.getLoanId()));

		Integer prodId = customerLoan.getLoanProductId();
		Optional<Loan> loanop = loanRepo.findById(prodId);
		if (!loanop.isPresent()) {
			throw new LoanNotFoundException("Loan Not found by Id" + prodId);
		} else {
			Loan loan = loanop.get();
			String type = loan.getCollateralType();
			try {
				if (type.equals("REAL_ESTATE")) {

					customerLoan.setCollateralId(realEstate.getCollateralId());
					customerLoanRepo.save(customerLoan);
					return client.saveRealEstateCollateral(token, realEstate);
				} else {
					throw new CollateralTypeNotFoundException("Collateral Mismatch");
				}
			} catch (FeignException e) {
				e.printStackTrace();
				throw new CollateralTypeNotFoundException("Collateral already exists with loan id");
			}
		}
	}

	/**
	 * Save Cash Deposit Implementation
	 * 
	 * @throws LoanNotFoundException
	 */
	@Override
	public ResponseEntity<String> saveCashDeposit(String token, CashDeposit cashDeposit)
			throws CustomerLoanNotFoundException, LoanNotFoundException {
		log.info("Save Cash Deposit collateral details");
		CustomerLoan customerLoan = customerLoanRepo.findById(cashDeposit.getLoanId())
				.orElseThrow(() -> new CustomerLoanNotFoundException(MESSAGE + cashDeposit.getLoanId()));

		Integer prodId = customerLoan.getLoanProductId();
		Optional<Loan> loanop = loanRepo.findById(prodId);
		if (!loanop.isPresent()) {
			throw new LoanNotFoundException("Loan not Found By Id:" + prodId);
		} else {
			Loan loan = loanop.get();
			String type = loan.getCollateralType();
			try {
				if (type.equals("CASH_DEPOSIT")) {
					customerLoan.setCollateralId(cashDeposit.getCollateralId());
					customerLoanRepo.save(customerLoan);
					return client.saveCashDepositCollateral(token, cashDeposit);
				} else {
					throw new CollateralTypeNotFoundException("Collateral Mismatch");
				}
			} catch (FeignException e) {

				throw new CollateralTypeNotFoundException("Collateral already exists with loan id");
			}
		}
	}

	@Override
	public Loan_Application applyLoan(Loan_Application loanApp) {
		log.info("Apply Loan");
		System.out.println("Inside loan management service By Customer");
		try {
			if (loanApp.getStatus().equals("applied")) {
				loanAppRepo.save(loanApp);
				return loanApp;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Loan_Application getLoanApplicationStatus(int loanAppId) throws LoanApplicationNotFoundException {
		log.info("Get Application Status using application Id");
		log.info(loanAppId + "");
		System.out.println("Inside loan management service By Customer");

		Loan_Application loanApp = loanAppRepo.findById(loanAppId)
				.orElseThrow(() -> new LoanApplicationNotFoundException(MESSAGE + loanAppId));

		System.out.println(loanApp);

		return loanApp;
	}


	@Override
	public Loan_Application getLoanApplicationStatus(String token ,int loanAppId) throws LoanApplicationNotFoundException {
		log.info("Get Application Status using application Id");
		log.info(loanAppId + "");
		System.out.println("Inside loan management service By Admin");

		Loan_Application loanApp = loanAppRepo.findById(loanAppId)
				.orElseThrow(() -> new LoanApplicationNotFoundException(MESSAGE + loanAppId));

		System.out.println(loanApp);

		return loanApp;
	}
	@Override
	public Loan_Application approveLoanApplication(String token, int loanAppId) throws LoanApplicationNotFoundException {

		Loan_Application loanApp = getLoanApplicationStatus(token,loanAppId);
		loanApp.setStatus("approved");
		loanAppRepo.save(loanApp);
		return loanApp;
	}

	@Override
	public Loan_Application rejectLoanApplication(String token, int loanAppId) throws LoanApplicationNotFoundException {

		Loan_Application loanApp = getLoanApplicationStatus(token,loanAppId);
		loanApp.setStatus("rejected");
		loanAppRepo.save(loanApp);
		return loanApp;
	}

}
