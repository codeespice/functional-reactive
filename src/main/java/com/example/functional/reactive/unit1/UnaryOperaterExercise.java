package com.example.functional.reactive.unit1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryOperaterExercise {
    public static void main(String[] args){
        UnaryOperator<String> unary = s->s.toLowerCase();
        List<String> names = Arrays.asList("Basics","Kite","Strong","Random");
        System.out.println("First Letter");
        List<String> lowerCase = checkFunction(names,unary);
        lowerCase.forEach(x->System.out.println(x));
    }
    public static <T> List<T> checkFunction(List<T> list, UnaryOperator<T> unary){
        List<T> finalList = new ArrayList<T>();
        for(T t : list){
            finalList.add(unary.apply(t));
        }
        return finalList;
    }
}
