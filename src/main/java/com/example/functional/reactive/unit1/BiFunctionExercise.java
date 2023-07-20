package com.example.functional.reactive.unit1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionExercise {
    public static void main(String[] args){
        BiFunction<String,String,String> biFunction = (a,b)->a.concat(" ").concat(b);
        List<String> firstNames = Arrays.asList("Rama","Krishna","Venkat","Shiva");
        List<String> lastNames = Arrays.asList("Sita","Radha","Padmavati","parvati");
        List<String> concatString = checkFunction(firstNames,lastNames,biFunction);
        concatString.forEach(x->System.out.println(x));
    }
    public static <T,U,R> List<R> checkFunction(List<T> list1, List<U> list2 ,BiFunction<T,U,R> fn){
        List<R> finalList = new ArrayList<R>();
        int size =0;
        if(list1.size()>=list2.size()){
            size=list1.size();
        }
        else
        {
            size=list2.size();
        }
        for(int i=0;i< size;i++) {

            finalList.add(fn.apply(list1.get(i),list2.get(i) ));
        }

        return finalList;
    }
}
