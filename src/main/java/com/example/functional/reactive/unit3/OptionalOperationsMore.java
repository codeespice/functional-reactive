package com.example.functional.reactive.unit3;

import java.util.Optional;
/*
optional.ifPresent()
        .ifPresentOrElse()
        .stream()
        .or() -> use alternate when option does not have any value
        .equal() -> not empty and value are equal
        .hashCode()->returns hashcode value , if empty returns 0
 */
public class OptionalOperationsMore {
    public static void main(String args[]){
        Optional<String>  optional = Optional.of("value");
        optional.ifPresent(System.out::println);
        //does not print anything because its empty
        Optional.empty().ifPresent(System.out::println);

        optional.ifPresentOrElse(System.out::println,()->System.out.println("Nothing"));

        //prints "Nothing" -> this method is used to do the default action if no valus is present
        Optional.empty().ifPresentOrElse(System.out::println,()->System.out.println("Nothing"));

        optional.stream().forEach(System.out::println);
        //does not print anything because stream is empty
        Optional.empty().stream().forEach(System.out::println);

        //if option is not empty return supplier
       Optional<String>  sm = optional.or(()->Optional.of("New Value"));
        System.out.println(sm);



        System.out.println( optional.equals(Optional.of("value")));
        System.out.println( optional.equals(Optional.of("values")));

        System.out.println( optional.hashCode());
        System.out.println(Optional.empty().hashCode());
    }
}
