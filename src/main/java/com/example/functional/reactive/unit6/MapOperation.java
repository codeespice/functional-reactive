package com.example.functional.reactive.unit6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapOperation {
    public static void main(String[] args){
        List<Integer> filteredStream = Stream.of(1,2,3,4,5,6)
                .map(x->x*20)
                .collect(Collectors.toList());

        filteredStream.forEach(System.out::println);


        //Books example
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Alchemist","Paul Cohelo","Adventure",4.408));
        books.add(new Book("The Notebook","Nicholos Sparks","Romance",4.10));
        books.add(new Book("Horror Cocktail","Robert Bloch","Horror",2.67));
        books.add(new Book("House of Leaves","Mark Z Daniel Lewiskie","Horror",4.109));

       List<String> bookNames = books.stream()
                .map(book->book.getName())
                .collect(Collectors.toList());
        System.out.println("bookNames:");
        bookNames.forEach(System.out::println);
    }
}
