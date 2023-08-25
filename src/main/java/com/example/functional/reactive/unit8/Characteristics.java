package com.example.functional.reactive.unit8;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

public class Characteristics {
    public static void main(String[] args) {
        List<Integer> list  = List.of(1,2,3,4);


        Stream<Integer> listStream = list.stream();
       Spliterator<Integer> listSpliterator = listStream.spliterator();
        int bits = listSpliterator.characteristics();
        System.out.println(Integer.bitCount(bits));

        //OR

        System.out.println(Integer.bitCount(bits | 0x00000010));

        //And

        System.out.println(bits & 0x00000010);

        System.out.println(listSpliterator.hasCharacteristics(0x00000010));

        long count = list.stream().filter(x -> {
            System.out.println("mapping");
            return x == x * 2;
        }).count();

        System.out.println(count);


//		//e.g
//		Stream.of(1,3,2,4,9)//ORDERED, SIZED
//		.filter(i->i%2==0) // ORDERED
//		.sorted() // ORDERED, SORTED
//		.map(i->i+1) // ORDERED
//		.unordered(); //

    }
}
