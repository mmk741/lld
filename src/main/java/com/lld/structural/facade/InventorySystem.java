package com.lld.structural.facade;

public class InventorySystem {

	public boolean checkStock(String itemName, int quantity) {
		System.out.println("Checking stock");
		return true;
	}

	public void updateStock(String itemName, int quantity) {
		System.out.println("Stock updated");
		
	}

}
