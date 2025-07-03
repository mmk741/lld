package com.lld.practice;


import com.lld.behavorial.state.VendingMachine;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*
            select a item
            pay for item
            dispense the item
            cancel the selected item

            state
                idle state
                selected Item state
                has money state
                dispensing state

            enum
                itemType
                    itemname(price)
                Coins
            class
                Item
                    itemType
                    itemCode

               Inventory
                    Map<Item,quantity>

                MoneyManager
                    List<Coins>

                 State
            VendingMachine
                Inventory
                MoneyManager
                State




          */


    }
}



