package com.example.functional.reactive.unit6;

import java.util.stream.Stream;

public class FlatMapStream {
    public static void main(String[] args){
        Stream<String> a = Stream.of("Hello","there !");
        Stream<String> b = Stream.of("How ","are you !");

        Stream<Stream<String>> c =  Stream.of(a,b); // this is stream os streams
        c.flatMap(e->e).forEach(System.out::println); //e->e identity function returns the same element
    }
}
