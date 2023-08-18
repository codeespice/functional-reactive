package com.example.functional.reactive.unit5.factory;

import java.util.function.Supplier;

public class FlooringFactory {

    public static Flooring getFlooring(int minTemp,int maxTemp){
        Supplier<Flooring> supplier;
        if(minTemp<=5 && maxTemp<=20){
            supplier =()-> new WoodenFlooring();
        }
        else if(minTemp<=5 && maxTemp>=45) {
            supplier =()-> new CorkFlooring();
        }
        else
        {
            supplier =()-> new ConcreteFlooring();
        }
     return supplier.get();
    }

}
