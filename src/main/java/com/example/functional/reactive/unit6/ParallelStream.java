package com.example.functional.reactive.unit6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class ParallelStream {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Alchemist","Paul Cohelo","Adventure",4.408));
        books.add(new Book("The Notebook","Nicholos Sparks","Romance",4.10));
        books.add(new Book("Horror Cocktail","Robert Bloch","Horror",2.67));
        books.add(new Book("House of Leaves","Mark Z Daniel Lewiskie","Horror",4.109));

        books.parallelStream().filter(book->book.getRating()>2) //Parallel Stream
                .forEach(System.out::println);

        ForkJoinPool pool = new ForkJoinPool(2);

        ForkJoinTask task = pool.submit(()->books.parallelStream().filter(book->book.getRating()>2).count());
        System.out.println(task.get());
    }
}
