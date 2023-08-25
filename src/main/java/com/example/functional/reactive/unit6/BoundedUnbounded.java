package com.example.functional.reactive.unit6;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BoundedUnbounded {
    public static void main(String[] args){
       Stream.of(1,2,3,4,5,6).forEach(System.out::println); //bounded Stream
        int[] array = { 8,9,10};
        Arrays.stream( array).forEach(System.out::println); //another way of creating streams

         Stream.Builder<Object> builder = Stream.builder().add(1); //another way of creating streams
        builder.add(2);
        builder.add(3);
        System.out.println("builded Stream : ");
       Stream<Object> builded =  builder.build();
        builded.forEach(System.out::println);



        //Unbounded Stream
        System.out.println("unbounded  Stream : ");
        Stream.iterate(0,i->i-1) // no end to stream but we are just limiting 10 testing purpose
                .limit(10)
                .forEach(System.out::println);

        System.out.println("Int unbounded Stream : ");
        IntStream.iterate(5,i->i+1)
                .limit(10)
                .forEach(System.out::println);


       // Stream.generate(()->"Hello").forEach(System.out::println); //infinite stream of hellos

       // Stream.generate(new Random()::nextInt)   //infinite stream of random numbers
      //          .forEach(System.out::println);

    }
}
