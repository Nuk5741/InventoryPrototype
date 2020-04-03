package com.nickwetter.inventory;

import com.nickwetter.Item.Item;

import java.util.ArrayList;
import java.util.List;

public class ParentList
{
    //Instance fields
    private String name;
    //This list holds all of the sublists, which hold all of the items
    private List<SubList> list = new ArrayList<SubList>();

    SublistFactory factory = new SublistFactory();

    //This class follows the singleton build pattern
    private static ParentList instance = new ParentList();

    private SubList selectedSublist;

    //Constructor
    private ParentList()
    {
        //When the ParentList is instantiated a single sublist is provided
        list.add(factory.createSublist("Default"));
        selectSublist("DEFAULT");
    }

    public static ParentList getInstance()
    {
        return instance;
    }

    public SubList getSelectedSublist(){return this.selectedSublist;}

    public List<SubList> getSublists(){return this.list;}


    //List functionality methods
    private SubList getByName(String name)
    {
        for(SubList s: list)
        {
            if(s.getName().equalsIgnoreCase(name))
                return s;
        }
        return null;
    }

    public void addSublist(String name)
    {
        if(getByName(name)==null)
            list.add(factory.createSublist(name));
        else
            System.out.println("There is already a sublist with that name!");
    }

    public boolean addSublist(SubList sublist)
    {
        boolean flag = false;
        if(getByName(sublist.getName())==null)
        {
            list.add(sublist);
            flag=true;
        }
        else
        {
            System.out.println("There is already a sublist with that name!");
        }
        return flag;
    }

    public void removeSublist(String name)
    {
        if(getByName(name)!=null)
        {
            list.remove(getByName(name));
            SubList.decrementCount();
        }
        else
            System.out.println("There is no sublist with that name!");
    }

    public void listSublists()
    {
        for(SubList s:list)
        {
            System.out.println(s.getName());
        }
    }

    public void selectSublist(String name)
    {
        if(getByName(name)!=null)
        {
            selectedSublist = getByName(name);
            System.out.println(selectedSublist.getName()+" selected!");
        }
        else
            System.out.println("There is no sublist with that name!");
    }

    public void addItem(Item item)
    {
        selectedSublist.addItem(item);
    }

    public void removeItem(Item item)
    {
        selectedSublist.removeItem(item);
    }

    public void listSublistItems()
    {
        selectedSublist.listItems();
    }

    public void listAllItems()
    {
        for(SubList s:list)
        {
            System.out.println(s.getName());
            s.listItems();
        }
    }

    //TODO: Add method to clear sublists of all Item data

}
