package com.lld.behavorial.visitor.example1;

public interface Visitor {
    //have abstract method for each element
    void visit(Book book);
    void visit(Fruit fruit);
}
