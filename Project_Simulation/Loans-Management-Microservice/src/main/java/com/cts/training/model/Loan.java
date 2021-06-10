package com.cts.training.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Loan Enity Class
 */
@Entity
@Table(name = "loan")
@NoArgsConstructor
@ApiModel(description = "Model Class for the Loan Details")
public class Loan {

	public Integer getLoanProductId() {
		return loanProductId;
	}

	public void setLoanProductId(Integer loanProductId) {
		this.loanProductId = loanProductId;
	}

	public String getLoanProductName() {
		return loanProductName;
	}

	public void setLoanProductName(String loanProductName) {
		this.loanProductName = loanProductName;
	}

	public Double getMaxLoanEligible() {
		return maxLoanEligible;
	}

	public void setMaxLoanEligible(Double maxLoanEligible) {
		this.maxLoanEligible = maxLoanEligible;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public Integer getTenure() {
		return tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	public String getCollateralType() {
		return collateralType;
	}

	public void setCollateralType(String collateralType) {
		this.collateralType = collateralType;
	}

	@Id
	@GeneratedValue
	@ApiModelProperty(value = "Id of the LoanProduct")
	private Integer loanProductId;

	@ApiModelProperty(value = "Name of the LoanProduct")
	private String loanProductName;

	@ApiModelProperty(value = "Maximum amount of Loan Eligible for the particular LoanProduct")
	private Double maxLoanEligible;

	@ApiModelProperty(value = "Interest on the LoanProduct")
	private Double interestRate;

	@ApiModelProperty(value = "Tenure of the LoanProduct")
	private Integer tenure;

	@ApiModelProperty(value = "Type of the Collateral")
	private String collateralType;

}
