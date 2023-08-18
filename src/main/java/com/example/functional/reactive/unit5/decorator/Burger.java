package com.example.functional.reactive.unit5.decorator;

public class Burger {
    private String burgerType;
    public Burger(){
        this.burgerType="";
    }
    private Burger(String type){
        this.burgerType=type;
    }
    public Burger addVeggies(){
        System.out.println("Adding vegggies to the burger");
        return new Burger(this.burgerType += " vegie");

    }
    public Burger addCheese(){
        System.out.println("Adding cheese to the burger");
        return new Burger(this.burgerType += " cheese");

    }

    @Override
    public String toString() {
        return "Burger{" +
                "burgerType='" + burgerType + '\'' +
                '}';
    }
}
