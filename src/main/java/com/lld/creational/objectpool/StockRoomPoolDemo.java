package com.lld.creational.objectpool;

public class StockRoomPoolDemo {

    ObjectPool<StockRoom> pool;

    private void setUp(int size) {
        pool = StockRoomPool.getInstance(size);
    }

    private int getSize() {
        return pool.size();
    }

    private void printIntanceId(StockRoom stockRoom) {
        System.out.println("Instance Id: "+ stockRoom.getInstanceId());
    }

    private void printPoolSize(StockRoomPoolDemo demo) {
        System.out.println("Pool size: " + demo.getSize());
    }

    public static void main(String[] args) {
       //setting up stockroomPool
        StockRoomPoolDemo demo = new StockRoomPoolDemo();
        demo.setUp(5);

        demo.printPoolSize(demo);

        StockRoom firstObject = demo.pool.borrowObject();

        demo.printIntanceId(firstObject);

        demo.printPoolSize(demo);

        StockRoom secondObject = demo.pool.borrowObject();

        demo.printIntanceId(firstObject);

        demo.printPoolSize(demo);

        demo.pool.returnObject(firstObject);

        demo.printPoolSize(demo);
    }

}
