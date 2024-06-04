package com.lld.behavorial.visitor;

public interface Visitor {
    //have abstract method for each element
    void visit(Book book);
    void visit(Fruit fruit);
}
