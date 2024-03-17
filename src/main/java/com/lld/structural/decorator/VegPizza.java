package com.lld.structural.decorator;

public class VegPizza implements Pizza {
	
	private String size = "Large";

	@Override
	public String getDescription() {
		return "This is a Veg Pizza of size: "+ this.size;
	}

	@Override
	public double getCost() {
		return 399.0;
	}

}
