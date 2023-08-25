package com.example.functional.reactive.unit6;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterOperation {
    public static void main(String[] args){
       List<Integer> filteredList = Stream.of(1,2,3,4,5,6)
                .filter(x->x%2==0)
                .collect(Collectors.toList());
        filteredList.forEach(System.out::println);
    }
}
