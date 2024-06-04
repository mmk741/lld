package com.lld.creational.objectpool;

public class StockRoom {

    private int stockNumber;

    private int instanceId = this.hashCode();

    public StockRoom(int stockNumber)  {
        this.stockNumber = stockNumber;
    }

    public int getStockNumber() {
        return stockNumber;
    }

    public int getInstanceId() {
        return instanceId;
    }
}
