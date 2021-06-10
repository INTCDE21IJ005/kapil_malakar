package com.cts.training.collateralwebportal.model;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDao {

	@NotNull
	private int applicationId;
	@NotNull
	private int customerId;
	@NotNull
	private int loanAmount;
	@NotNull
	private int tenure;
	@NotNull
	private String collateralDetails;
	@NotNull
	private String status;
	
}
