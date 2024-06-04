package com.lld.structural.facade;

public class Client {
	
	public static void main(String[] args) {
		/*
		 * InventorySystem inventorySystem = new InventorySystem(); PaymentSystem
		 * paymentSystem = new PaymentSystem();
		 * 
		 * String itemName = "Biscuits"; int quantity = 10; String cardNumber = "1234";
		 * 
		 * if (inventorySystem.checkStock(itemName, quantity)) { if
		 * (paymentSystem.processPayment(cardNumber)) {
		 * inventorySystem.updateStock(itemName, quantity); } }
		 */
		
		OrderFacade orderFacade = new OrderFacade();
		String itemName = "Biscuits"; 
		int quantity = 10; 
		String cardNumber = "1234";
		
		orderFacade.placeOrder(itemName, quantity, cardNumber);
		
		
	}

}
