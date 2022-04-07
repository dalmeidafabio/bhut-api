package com.bhut.api.api.domain.model;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
public class Car {

	@EqualsAndHashCode.Include
	private String _id;
	
	private String title;
	
	private String brand;
	
	private BigDecimal price;
	
	private Integer age;
	
	private Integer __v;
}
