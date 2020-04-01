package com.nickwetter.Item;

public class Item
{

    //Instance fields
    private String name;
    private int quantity;

    //Optional Parameters
    private int ID;
    private double pricePerUnit;
    private double totalPrice;

    //Constructor
    private Item(ItemBuilder builder)
    {
        this.name=builder.name;
        this.quantity=builder.quantity;
        this.ID=builder.ID;
        this.pricePerUnit=builder.pricePerUnit;
        this.totalPrice = builder.quantity*builder.pricePerUnit;
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public Integer getID() {
        return ID;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public String toString()
    {
        return this.name+", QTY: "+this.quantity;
    }

    public String fullPrint()
    {
        return this.name+", QTY: "+this.quantity+", ID: "+this.ID
                + ", PPU: $"+this.pricePerUnit+", Total Price: $"+this.totalPrice;
    }

    //Comparison Methods
    public int compareByName(Item item)
    {
        //TODO: Finish implementation
        int diff=0;
        for(int i = 0; i<this.name.length() || i<item.name.length(); i++)
        {
            diff += this.name.charAt(i)-item.name.charAt(i);
        }
        return diff;
    }

    public int compareByQuantity(Item item)
    {
        return this.quantity-item.quantity;
    }

    public int compareByID(Item item)
    {
        return this.ID-item.ID;
    }

    public double compareByPricePerUnit(Item item)
    {
        return this.pricePerUnit-item.pricePerUnit;
    }

    public double compareByTotalPrice(Item item)
    {
        return this.totalPrice-item.totalPrice;
    }

    //Builder Class
    public static class ItemBuilder
    {
        //Instance fields
        private String name;
        private int quantity;

        //Optional Parameters
        private int ID;
        private double pricePerUnit;
        private double totalPrice;

        public ItemBuilder(String name, int quantity)
        {
            this.name=name;
            this.quantity=quantity;
        }

        public ItemBuilder setID(int ID)
        {
            this.ID=ID;
            return this;
        }

        public ItemBuilder setPricePerUnit(double pricePerUnit)
        {
            this.pricePerUnit=pricePerUnit;
            return this;
        }

        public Item build()
        {
            return new Item(this);
        }

    }

}