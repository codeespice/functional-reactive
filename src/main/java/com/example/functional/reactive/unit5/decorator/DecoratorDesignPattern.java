package com.example.functional.reactive.unit5.decorator;

public class DecoratorDesignPattern {
    public static void main(String args[]){
       Burger order =  new BurgerShop(burger->burger.addVeggies()).use(new Burger());
       System.out.println("order="+order);
       Burger enhanceOrder = new BurgerShop(burger->burger.addCheese()).use(order);
       System.out.println("enhanceOrder="+order);
    }
}
