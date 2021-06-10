package com.cts.training.pojo;


import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.Setter;
/**
 * Collateral POJO Class
 */
@Inheritance(strategy = InheritanceType.JOINED)
@ApiOperation(value = "Model class for collaterals.")
public class Collateral {
	
	public Integer getCollateralId() {
		return collateralId;
	}

	public void setCollateralId(Integer collateralId) {
		this.collateralId = collateralId;
	}

	public Integer getLoanId() {
		return loanId;
	}

	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

	public CollateralType getCollateralType() {
		return collateralType;
	}

	public void setCollateralType(CollateralType collateralType) {
		this.collateralType = collateralType;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerAddress() {
		return ownerAddress;
	}

	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}

	public Long getOwnerContact() {
		return ownerContact;
	}

	public void setOwnerContact(Long ownerContact) {
		this.ownerContact = ownerContact;
	}

	public Double getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(Double currentValue) {
		this.currentValue = currentValue;
	}

	@ApiModelProperty(value = "Id of the collateral.")
	private Integer collateralId;

	@ApiModelProperty(value = "Id of the loan.")
	private Integer loanId;

	@ApiModelProperty(value = "Type of collateral-CashDeposit/RealEstate")
	private CollateralType collateralType;

	@ApiModelProperty(value = "Name of owner.")
	private String ownerName;

	@ApiModelProperty(value = "Address of owner.")
	private String ownerAddress;

	@ApiModelProperty(value = "Contact number of owner.")
	private Long ownerContact;

	@ApiModelProperty(value = "Current Value of the collateral.")
	private Double currentValue;
}
