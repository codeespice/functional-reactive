package com.example.functional.reactive.unit5.fluent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Order {
    private List<String> cart = new ArrayList<>();
    private String address;
    public Order(){

    }
   public Order(List<String> cart,String address){
        this.cart   =cart;
        this.address=address;
    }
    public Order addItem(String item){
        this.cart.add(item);
        System.out.println("Item Has been added to the cart");
        return new Order(this.cart,this.address);
    }
    public Order addAddress(String address){
        this.address=address;
        System.out.println("Address Has been added to the cart");
        return new Order(this.cart,this.address);
    }

    public void placeOrder(){
        System.out.println(String.format("order has been placed for %s to the address %s",this.cart,this.address));
    }
    public static void placeOrderFunction(Function<Order,Order> fn){
        Order order = fn.apply(new Order());
        System.out.println(String.format("order has been placed for %s to the address %s",order.cart,order.address));
    }
}
