package com.example.functional.reactive.unit3;

import java.util.Optional;

/*
1. Optional map()
            filter()
            flatMap()
 */
public class OptionalOperations {
    public static void main(String args[]){
        String val ="Renew";
        Optional<String> optional = Optional.of(val);
        //use map on Optional , No matter what when ever you get value you use orElse
       String v=  optional.map(x->"Replaced").orElse("Empty");
       System.out.println(v);
        Optional<String> optional1 = Optional.empty();
        //if map throws error use orElse to be on safeside
        String v1 =  optional1.map(x->"Replaced").orElse("Empty");
        System.out.println(v1);

        //apply filter on the value
        Optional<String> optional2 = optional.filter(m->m.equals("Renew"));
        String v2 =  optional2.orElse("Empty");
        System.out.println(v2);


       Optional<String> flatmap =  optional.flatMap(s->Optional.of("Replaced by flatmap"));
        System.out.println(flatmap.orElse("EMPTY"));

    }
}
