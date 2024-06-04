package com.lld.creational.factory.simpleFactory;

public class Tester {

    public static void main(String[] args) {
        Shape circle=ShapeFactory.getShape("Circle");
        Shape qwer=ShapeFactory.getShape("Cirkjhvc");
        System.out.println(circle instanceof Circle);
    }

}
