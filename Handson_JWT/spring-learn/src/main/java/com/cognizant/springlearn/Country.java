package com.cognizant.springlearn;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Country {
	
	@NotNull
	@Size(min=2,max=2,message="Country code should be of 2 characters only")
	private String code;
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country() {
		super();
		System.out.println("Inside Country Constructor");
		//LOGGER.debug("Inside Country Constructor");
	}

	public Country(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}

}
