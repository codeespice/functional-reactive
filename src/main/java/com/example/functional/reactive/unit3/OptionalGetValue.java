package com.example.functional.reactive.unit3;

import java.util.Optional;
/*
    get()
    isPresent()
    orElse(other)
    orElseGet(supplier)
    orElseThrow(exception)
    orElseThrow()
 */
public class OptionalGetValue {
    public static void main(String args[]){
        int a =10;
        Optional<Integer> optional = Optional.of(a);

        //don't use optional.get
        Integer val = optional.get();
        System.out.println(val);
        //use always or else
        Integer valq = optional.orElse(0);
        System.out.println(valq);
        //prefer above one because supplier is called everytime
        Integer valz = optional.orElseGet(()->0);
        System.out.println(valz);
        //same as above,but prefer above one
        Integer valm= optional.isPresent()?optional.get():0;
        System.out.println(valm);

        Optional<Integer> emptyOptional  = Optional.empty();
        //Throws exception when no value is found
        Integer orElseThrow= emptyOptional.orElseThrow(()->new IllegalArgumentException());

    }
}
