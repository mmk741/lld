package com.lld.behavorial.visitor;

public class ShoppingCartVisitor implements Visitor{
    @Override
    public void visit(Book book) {
        System.out.println("Book: " + book.getTitle() + " costs $" + book.getPrice());
    }

    @Override
    public void visit(Fruit fruit) {
        double cost = fruit.getPricePerKg() * fruit.getWeight();
        System.out.println(fruit.getName() + " costs $" + cost);
    }
}
