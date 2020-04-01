package com.nickwetter.inventory;

public class SublistFactory
{

    public SubList createSublist(String name)
    {
        return new SubList(name);
    }

}
