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

}
