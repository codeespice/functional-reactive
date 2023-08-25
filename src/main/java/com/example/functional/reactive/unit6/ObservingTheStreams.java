package com.example.functional.reactive.unit6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ObservingTheStreams {
    public static void main(String[] args){
        List<Book> books = new ArrayList<>();

      List<Book> filteredBooks =   books.stream()
                .filter(book->book.getGenre().equalsIgnoreCase("Horror"))
                .filter(book->book.getRating()>3)
                .collect(Collectors.toList());

        filteredBooks.forEach(System.out::println);

        //1.Source
      Stream<Book> bookStream = books.stream();

      //2.Intermediate operation
        Stream<Book> filteredGenreStream =   bookStream.filter(book->book.getGenre().equalsIgnoreCase("Horror"));


       //3. Intermediate operation
        Stream<Book> filteredRatingStream =  filteredGenreStream.filter(book->book.getRating()>3);

        //4. Terminal Operation
        List<Book> fileterdBooks = filteredRatingStream.collect(Collectors.toList());
    }
}
