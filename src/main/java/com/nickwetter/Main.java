package com.nickwetter;

import com.nickwetter.Item.Item;
import com.nickwetter.inventory.ParentList;
import com.nickwetter.inventory.SubList;

public class Main
{
    public static void main(String[] args)
    {

        Item chair = new Item.ItemBuilder("Chair",5).setPricePerUnit(34.21).build();
        Item bench = new Item.ItemBuilder("Bench", 2).build();

        ParentList list = ParentList.getInstance();
        list.addSublist("Bedroom");
        list.addSublist("Kitchen");
        list.selectSublist("KITCHEN");

        list.addItem(chair);
        list.listSublistItems();
        list.selectSublist("BEDROOM");
        list.addItem(bench);
        list.listSublistItems();
        list.listAllItems();








        //System.out.println(chair.compareByName(bench));

    }
}
