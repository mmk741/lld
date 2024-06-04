package com.lld.structural.decorator;

public class Client {
	
	public static void main(String[] args) {
		Pizza vegPizza = new VegPizza();
		vegPizza = new CheeseDecorator(vegPizza);
		vegPizza = new BellPepperDecorator(vegPizza);
		
//		System.out.println(vegPizza.getDescription());
		System.out.println(vegPizza.getCost());
	
	}

}
