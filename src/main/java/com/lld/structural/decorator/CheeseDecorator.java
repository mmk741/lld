package com.lld.structural.decorator;

public class CheeseDecorator extends PizzaDecorator{

	public CheeseDecorator(Pizza pizza) {
		super(pizza);
	}

	@Override
	public String getDescription() {
		return pizza.getDescription()+" + Extra Cheese";
	}

	@Override
	public double getCost() {
		return pizza.getCost() + 99;
	}

}
