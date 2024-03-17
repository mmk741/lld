package com.lld.structural.decorator;

public class BellPepperDecorator extends PizzaDecorator{

	public BellPepperDecorator(Pizza pizza) {
		super(pizza);
	}

	@Override
	public String getDescription() {
		return pizza.getDescription()+" + Bell Pepper";
	}

	@Override
	public double getCost() {
		return pizza.getCost() + 199;
	}

}
