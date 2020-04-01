package com.nickwetter;

import com.nickwetter.Item.Item;

public class Main
{
    public static void main(String[] args)
    {
        Item chair = new Item.ItemBuilder("Chair",5).setPricePerUnit(34.21).build();
        Item bench = new Item.ItemBuilder("Bench", 2).build();

        System.out.println(chair.compareByQuantity(bench));

    }
}
