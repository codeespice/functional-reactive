package com.example.functional.reactive.unit1;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExcercise {
    public static void main(String args[]){
    List<Integer> list = List.of(20,300,40,500,60);
    Consumer<Integer> consumer = e->System.out.println(e);
        Consumer<Integer> rangeConsumer = e->{
            if(e>100){
            System.out.println(e);
            }
        };
        consume(list,consumer);
        System.out.println("Range Consumer");
        consume(list,rangeConsumer);

    }
    public static <T> void consume(List<T> list , Consumer<T> consumer){
       for(T t: list){
           consumer.accept(t);
       }
    }
}
