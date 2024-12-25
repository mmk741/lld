package com.lld.creational.factory.simpleFactory;

public class ShapeFactory {

    //enum can be used in method input
    public static Shape getShape(String name) {
        if (name.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (name.equalsIgnoreCase("rectangle")) {
            return new Rectange();
        } else if (name.equalsIgnoreCase("square")) {
            return new Square();
        }else {
            throw new IllegalArgumentException("This name is not supported");
        }
    }
}
