package com.example.functional.reactive.unit4;

public class ReferentialTransparency {
    public static void main(String args[]){
        int result  = add(3,multiply(2,5));  // referential transparency , i.e same result as add(3,10)
        System.out.println(result);
    }
    public static  int add(int a , int b){
        return a+b;
    }
    public static int multiply(int a , int b){

        return a*b;
    }
    public static void log(String s ){
        System.out.println(s);
    }
}
