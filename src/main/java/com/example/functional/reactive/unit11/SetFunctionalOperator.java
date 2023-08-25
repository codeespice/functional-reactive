package com.example.functional.reactive.unit11;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SetFunctionalOperator {
    public static void main(String[] args){
        Set<Integer> set = Set.of(23,234,1,3,4,5,8);
        System.out.println("Set ::");
        set.forEach(System.out::println);

        System.out.println("Filtered set ::");
        set.stream()
                .filter(element->element%2==0)
                .forEach(System.out::println);


        System.out.println("Soretd set ::");
        set.stream()
                .sorted()
                .forEach(System.out::println);


      Set<Double> hashset=  set.stream()
                .map(element->Double.valueOf(element))
                .collect(Collectors.toSet());
        System.out.println("Hash set ::");
        hashset.forEach(System.out::println); //no order when streaming though set


       TreeSet<Double> sortedSet=  set.stream()
                .map(element->Double.valueOf(element))
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("Sorted set ::");
        sortedSet.forEach(System.out::println); //ordered


        int sum = set.stream()
                .mapToInt(element->element)
                .sum();

        System.out.println("Sum ::"+ sum);

    }
}
