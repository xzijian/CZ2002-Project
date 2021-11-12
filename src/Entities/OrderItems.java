package Entities;

import java.io.Serializable;

public class OrderItems implements Serializable {
    private MenuItems orderItem;
    private double price;

    public OrderItems(MenuItems orderItem){
        this.orderItem = orderItem;
        this.price = orderItem.getPrice();
    }

    public MenuItems getMenuItem(){ return this.orderItem; }
    public double getPrice(){ return this.price; }
    public String toString(){ return this.getMenuItem().getName(); }

}
