package com.lld.structural.adapter;

import java.util.ArrayList;
import java.util.List;

//Let’s say we have a ShopInventory which maintains a list of products. Later on, we took over another store
//        inventory which sells groceries. We now want to add those items to our ShopInventory.
//        The problem we have here is that although the GroceryItem is
//        just a type of product but is unrelated to the Product interface.
//
//        To solve this problem, we’ll use the adapter pattern. We’ll create a GroceryItemAdapter
//        which will implement the Product interface:
//https://www.programmergirl.com/java-adapter-pattern/
public class AdapterPattern {
    public static void main(String[] args) {
        //code in our main method
        ShopInventory inventory = new ShopInventory();

        //adding regular store products - ones that implement Product interface
        inventory.addProduct(new CosmeticProduct("Lavie Handbag", 5000.0));
        inventory.addProduct(new FitnessProduct("Yoga SmartFit", 2000.75));


        //adding GroceryItem to the store using an adapter
        GroceryItem groceryItem = new GroceryItem("Wheat Flour", 100);
        inventory.addProduct(new GroceryItemAdapter(groceryItem));
    }
}

//client
 interface Product {

    String getName();
    double getPrice();
}

 class CosmeticProduct implements Product {

    private String name;
    private double price;

     public CosmeticProduct(String name, double price) {
         this.name = name;
         this.price = price;
     }


     @Override
     public String getName() {
         return name;
     }

     @Override
     public double getPrice() {
         return price;
     }
 }

class FitnessProduct implements Product {

    private String name;
    private double price;

    public FitnessProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

 class ShopInventory {

    private List<Product> products;

    public ShopInventory() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }
}

//third-party code need to adjust with shopInventory// existing interface
class GroceryItem {

    private String itemName;
   private int costPerUnit;

    public GroceryItem(String itemName, int costPerUnit) {
        this.itemName = itemName;
        this.costPerUnit = costPerUnit;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(int costPerUnit) {
        this.costPerUnit = costPerUnit;
    }


}

//adapter to connect third party code it have all method which is used by product
class GroceryItemAdapter implements Product {

    private GroceryItem groceryItem;

    public GroceryItemAdapter(GroceryItem groceryItem) {
        this.groceryItem = groceryItem;
    }

    public String getName() {
        return groceryItem.getItemName();
    }

    public double getPrice() {
        return groceryItem.getCostPerUnit();
    }
}
