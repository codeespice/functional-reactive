package com.example.functional.reactive.unit5.decorator;

import com.example.functional.reactive.unit5.decorator.Burger;

import java.util.function.Function;

public class BurgerShop {
    Function<Burger,Burger> decorator ;
    public BurgerShop(Function<Burger,Burger> decorator ){
        this.decorator=decorator;
    }
    public Burger use(Burger burger){
        return decorator.apply(burger);
    }
}
