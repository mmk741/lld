package com.lld.creational.objectpool;

public class StockRoomPool extends ObjectPool<StockRoom>{

   private static  StockRoomPool instance;



    private int stockNumber = 1234;

    private StockRoomPool(int size) {
        super(size);
    }

    public static StockRoomPool getInstance(int size) {
        if (instance == null) {
            synchronized (StockRoomPool.class) {
                if (instance == null) {
                    instance = new StockRoomPool(size);
                }
            }
        }
        return instance;
    }

    @Override
    public StockRoom create() {
        StockRoom stockRoom = new StockRoom(stockNumber);
        System.out.println("Creating instance with instance Id "+ stockRoom.getInstanceId());
        return stockRoom;
    }

}

