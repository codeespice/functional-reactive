package com.example.functional.reactive.unit3;

import java.util.Optional;
/*
1.Optional are immutable
2.Optional is object and is container of value
 */
public class OptionalCreation {
    public static void main(String args[]){
        String val ="Hello";
        Optional<String> optional = Optional.of(val);
        Optional<Integer> optional1 = Optional.empty();
        Optional<String> nullable = Optional.ofNullable(val);
        Optional<String> emptyOptioan = Optional.ofNullable(null);
    }
}
