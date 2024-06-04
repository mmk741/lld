package com.lld.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {
    private String name;
    private List<FileSystem> children = new ArrayList<>();
    
    public Directory(String name) {
        this.name = name;
    }
    
    public void add(FileSystem component) {
        children.add(component);
    }
    
    public void remove(FileSystem component) {
        children.remove(component);
    }
    
    public void display() {
        System.out.println("Directory: " + name);
        for (FileSystem component : children) {
            component.display();
        }
    }

}
