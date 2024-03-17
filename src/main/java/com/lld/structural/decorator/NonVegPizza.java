package com.lld.structural.decorator;

public class NonVegPizza implements Pizza {
	
	private String size = "Large";

	@Override
	public String getDescription() {
		return "This is a NonVeg Pizza of size: "+ this.size;
	}

	@Override
	public double getCost() {
		return 899.0;
	}

}
