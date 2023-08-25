package com.example.functional.reactive.unit10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CustomCollector {
    public static void main(String args[]){
        List<Integer>  numbers = List.of(1,2,3,4,5,6,7,8,9,10);
        /*
        1. Supplier -> supplier
        2.Accumulator -> Biconsumer
        3.Combiner ->Binary Operator
        4.Finisher ->Function
        5.Characteristics -> Set

         */
        Collector<Integer,List<Integer> , List<Integer> > toList = Collector.of(()->new ArrayList(),   //supplier returns arraylist
                                             (list,e)->list.add(e) , //bifunction takes list and element and add element to the list
                                            (list1,list2)-> {   // used for parallelization , two lists are combined during parallel processing
                                        list1.addAll(list2);
                                            return list1;
                                            },
                                            Collector.Characteristics.IDENTITY_FINISH); // namesake finisher, do not need further processing

    List<Integer> filtered = numbers.stream().
                filter(element->element%2==0).
                    collect(toList);
        System.out.println("Filtered :::");
        filtered.forEach(System.out::println);


        List<Integer> unsorted = List.of(10,5,2,4,15,23);
        Collector<Integer,List<Integer> , List<Integer> > toSorted = Collector.of(ArrayList::new,   //supplier returns arraylist
                (list,e)->list.add(e) , //bifunction takes list and element and add element to the list
                (list1,list2)-> {   // used for parallelization , two lists are combined during parallel processing
                    list1.addAll(list2);
                    return list1;
                },
                (list)-> {
                Collections.sort(list);            // sort the list
                return list; },
                Collector.Characteristics.UNORDERED); // namesake finisher, do not need further processing


        List<Integer> sorted = unsorted.stream()
                                .collect(toSorted);
        System.out.println("Sorted :::");
        sorted.forEach(System.out::println);

    }
}
