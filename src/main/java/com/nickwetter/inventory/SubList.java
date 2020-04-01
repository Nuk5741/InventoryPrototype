package com.nickwetter.inventory;

import com.nickwetter.Item.Item;

import java.util.ArrayList;
import java.util.List;

public class SubList
{
    private String name;
    private List<Item> list = new ArrayList<Item>();

    private static int sublistCount = 0;

    protected SubList(String name)
    {
        this.name=name;
        sublistCount++;
    }

    public String getName() {
        return name;
    }

    //Only to be called when removing a sublist from parentlist
    protected static void decrementCount()
    {
        sublistCount--;
    }

    public static void printCount()
    {
        System.out.println(sublistCount);
    }

    //List functionality methods
    private Item getByName(String name)
    {
        for(Item i: list)
        {
            if(i.getName().equalsIgnoreCase(name))
                return i;
        }
        return null;
    }

    private Item getByID(int ID)
    {
        for(Item i: list)
        {
            if(i.getID()==ID)
                return i;
        }
        return null;
    }

    public void addItem(Item item)
    {
        if(getByName(item.getName()) == null && getByID(item.getID()) == null)
            list.add(item);
        else
            System.out.println("There is already an item with that name/ID!");
    }

    public void removeItem(Item item)
    {
        if(getByName(item.getName()) != null)
            list.remove(item);
        else
            System.out.println("There is no item with that name!");
    }

    public void listItems()
    {
        for(Item i:list)
            System.out.println(i);
    }


}
