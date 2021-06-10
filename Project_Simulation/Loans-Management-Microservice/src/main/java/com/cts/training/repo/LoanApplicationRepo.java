package com.cts.training.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cts.training.model.Loan_Application;

/**
 * Loan Application Entity Curd Repository
 */
@Repository
public interface LoanApplicationRepo extends CrudRepository<Loan_Application, Integer> {

}
