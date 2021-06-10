package com.cts.training.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Customer Entity Class
 * 
 */

@NoArgsConstructor
@Entity
@Table(name = "customer")
@ApiModel(description = "Model Class for Customer Details")
public class Customer {

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmailId() {
		return customerEmailId;
	}

	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}

	public String getCustomerPhoneNo() {
		return customerPhoneNo;
	}

	public void setCustomerPhoneNo(String customerPhoneNo) {
		this.customerPhoneNo = customerPhoneNo;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	@Id
	@ApiModelProperty(value = "Id of the Customer")
	private Integer customerId;

	@ApiModelProperty(value = "Name of the Customer")
	private String customerName;

	@ApiModelProperty(value = "Email Id of the Customer")
	private String customerEmailId;

	@ApiModelProperty(value = "Phone Number of the Customer")
	private String customerPhoneNo;

	@ApiModelProperty(value = "Address of the Customer")
	private String customerAddress;

}
