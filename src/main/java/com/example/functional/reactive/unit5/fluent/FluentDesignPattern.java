package com.example.functional.reactive.unit5.fluent;

public class FluentDesignPattern {
    public static void main(String[] args){
       Order order = new Order();
        order.addItem("Soap")
                .addItem("Paste")
                .addAddress("demo me")
                .placeOrder();

// functional implementation
        Order.placeOrderFunction(order1 -> {
            order1.addItem("Soap");
            order1.addItem("paste");
            order1.addAddress("demo me");
            return order1;
        });
    }
}
