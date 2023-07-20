package com.example.functional.reactive.unit1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionExercise {
    public static void main(String[] args){
        Function<String,Integer> fn = s->s.length();

        List<String> names = Arrays.asList("Basics","Kite","Strong","Random");
        List<Integer> lengths = checkFunction(names,fn);
        lengths.forEach(x->System.out.println(x));
        List<String> firstLetter = checkFunction(names,x->x.substring(0,1));
        System.out.println("First Letter");
        firstLetter.forEach(x->System.out.println(x));

    }
    public static <T,R> List<R> checkFunction(List<T> list,Function<T,R> fn){
        List<R> finalList = new ArrayList<R>();
        for(T t : list){
            finalList.add(fn.apply(t));
        }
        return finalList;
    }
}
