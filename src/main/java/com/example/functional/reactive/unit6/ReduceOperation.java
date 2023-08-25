package com.example.functional.reactive.unit6;

import java.util.stream.Stream;

public class ReduceOperation {
    public static void main(String[] args){
     int sum =    Stream.of(1,2,3,4,5,6,7,8,9,10)
        .reduce(0,(a,b)->a+b);
     System.out.println("Sum is : "+sum);
    }
}
