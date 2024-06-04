package com.lld.structural.facade;

public class OrderFacade {
    private InventorySystem inventorySystem;
    private PaymentSystem paymentSystem;

    public OrderFacade() {
        this.inventorySystem = new InventorySystem();
        this.paymentSystem = new PaymentSystem();
    }

    public boolean placeOrder(String itemName, int quantity, String cardNumber) {
        boolean orderPlaced = false;
        if (inventorySystem.checkStock(itemName, quantity)) {
            if (paymentSystem.processPayment(cardNumber)) {
                inventorySystem.updateStock(itemName, quantity);
                orderPlaced = true;
            }
        }
        return orderPlaced;
    }
}
