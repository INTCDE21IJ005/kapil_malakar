package com.cts.training.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "loanapplication")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Model Class for Customer Taking the Loan")
public class Loan_Application {
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public String getCollateralDetails() {
		return collateralDetails;
	}
	public void setCollateralDetails(String collateralDetails) {
		this.collateralDetails = collateralDetails;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Id
	@GeneratedValue
	@ApiModelProperty(value = "Id of the Application")
	private int applicationId;
	@ApiModelProperty(value = "Id of the Customer")
	private int customerId;
	@ApiModelProperty(value = "Loan Amount")
	private int loanAmount;
	@ApiModelProperty(value = "Tenure of the Loan")
	private int tenure;
	@ApiModelProperty(value = "Details of the Collateral")
	private String collateralDetails;
	@ApiModelProperty(value = "Status of the Application")
	private String status;
	
}
