package com.lld.structural.proxy;

public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // Image is loaded and displayed on first access
        image1.display();

        // Image is displayed directly without loading on subsequent access
        image1.display();

        // Another image is loaded and displayed on first access
        image2.display();
    }
}
