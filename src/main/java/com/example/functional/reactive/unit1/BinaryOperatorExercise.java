package com.example.functional.reactive.unit1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class BinaryOperatorExercise {
    public static void main(String[] args){
        BinaryOperator<String> binaryOperator = (a,b)->a + "."+b;
        List<String> firstNames = Arrays.asList("Rama","Krishna","Venkat","Shiva");
        List<String> lastNames = Arrays.asList("Sita","Radha","Padmavati","parvati");
        List<String> concatString = checkFunction(firstNames,lastNames,binaryOperator);
        concatString.forEach(x->System.out.println(x));
    }
    public static <T> List<T> checkFunction(List<T> list1, List<T> list2 , BiFunction<T,T,T> fn){
        List<T> finalList = new ArrayList<T>();
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
