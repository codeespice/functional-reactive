package com.example.functional.reactive.unit1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExercise {
    public static void main(String args[]){
        List<String> names = Arrays.asList("Basics","","Strong","");

        Predicate<String> checkEmpty = s->!s.isEmpty();
        Predicate<String> basics = s->s.contains("Basics");
        List<String> filteredNames  =removeEmpty(names,checkEmpty);
        List<String> filteredSpecific  =removeEmpty(names,basics);
        System.out.println("Filtered names");
        filteredNames.forEach(x->System.out.println(x));
        System.out.println("Specific names");
        filteredSpecific.forEach(x->System.out.println(x));

        List<Integer> intList = Arrays.asList(1,0,2,0,3,0);
        List<Integer> finalList = removeEmpty(intList,x->x>0);
        System.out.println("remove zeros");
        finalList.forEach(x->System.out.println(x));
    }
    public static <T> List<T> removeEmpty(List<T> names,Predicate<T> checkEmpty){
    List<T> a = new ArrayList<>();
    for(T s : names ){
        if(checkEmpty.test(s)){
            a.add(s);
        }
    }
        return a;
    }
}
