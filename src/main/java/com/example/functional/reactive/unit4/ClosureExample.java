package com.example.functional.reactive.unit4;

public class ClosureExample {
    public static void main(String args[]){

        int x =  10;

        Function<Integer,Integer> f1 =m->{

            return m+x;
        };
/*
f1 is closure since it refers to x
 */
       System.out.println( f1.doAction(10));
 }
}
