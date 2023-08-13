package com.example.functional.reactive.unit4;

import java.util.function.Function;

public class CurryingExample {
    public static void main(String args[]) {

      /*  Function<Integer, Function<Integer,Integer>> func1 = u->{
            return v->u+v;
        };*/
        /*
        take u as input and return function v which adds u and v
         */
        Function<Integer,Function<Integer,Integer>> func1 = u->v->u+v;
        Function<Integer,Integer> func2 = func1.apply(5);
        int sum = func2.apply(6);
        System.out.println(sum);
        int sum2 = func2.apply(8);
        System.out.println(sum2);

        Function<Integer,Function<Integer,Function<Integer,Integer>>> func3 = u->v->w->u+v+w;
        int currySum  = func3.apply(8).apply(6).apply(9);
        System.out.println(currySum);
           }
}
