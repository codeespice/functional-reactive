package com.example.functional.reactive.unit6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SingleUse {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Alchemist","Paul Cohelo","Adventure",4.408));
        books.add(new Book("The Notebook","Nicholos Sparks","Romance",4.10));
        books.add(new Book("Horror Cocktail","Robert Bloch","Horror",2.67));
        books.add(new Book("House of Leaves","Mark Z Daniel Lewiskie","Horror",4.109));
        List<Book> filteredBooks = books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase("Horror"))
                .filter(book -> book.getRating() > 3)
                .collect(Collectors.toList());

        filteredBooks.forEach(System.out::println);
    }
    }
