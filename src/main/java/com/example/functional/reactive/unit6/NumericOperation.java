package com.example.functional.reactive.unit6;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericOperation {
    public static void main(String[] args){

        //Books example
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Alchemist","Paul Cohelo","Adventure",4.408));
        books.add(new Book("The Notebook","Nicholos Sparks","Romance",4.10));
        books.add(new Book("Horror Cocktail","Robert Bloch","Horror",2.67));
        books.add(new Book("House of Leaves","Mark Z Daniel Lewiskie","Horror",4.109));

        OptionalDouble averageVal= books.stream()
                        .mapToDouble(book->book.getRating()) // use map to double
                                .average();
        System.out.println("average:"+averageVal.getAsDouble());

        IntStream intStream = IntStream.of(1,2,3,4,5,6);
       // intStream.boxed() ;// returns object version of stream
       // intStream.mapToDouble()
        System.out.println("Summary Stats : "+intStream.summaryStatistics());
        System.out.println("Summary max : "+IntStream.of(1,2,3,4,5,6).max());
        System.out.println("Average : "+IntStream.of(1,2,3,4,5,6).average());
        DoubleStream doubleStream = DoubleStream.of(1.0,1.3,2.3,2.6);
        //doubleStream.mapToObj()

    }
}
