package com.example.functional.reactive.unit1;

import java.util.function.Supplier;

public class SupplierExercise {
    public static void main(String[] args){
        Supplier<String> supplier = ()-> new String("A String");
        System.out.println(supplier.get());

        Supplier<Double> randomSupplier = ()->Math.random();
        System.out.println(randomSupplier.get());

    }
}
