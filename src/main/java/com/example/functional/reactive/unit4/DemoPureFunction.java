package com.example.functional.reactive.unit4;

public class DemoPureFunction {
    public static void main(String args[]){
        int result  = add(3,multiply(2,5)); //Non pure function since multiply has print i.e side effect
        int result1  = add(3,5);//pure function because it does not depend on external algorithm or function
    }
    public static  int add(int a , int b){
        return a+b;
    }
    public static int multiply(int a , int b){
        log(String.format("returning %s as the result of %s * %s ",a*b,a,b));
        return a+b;
    }
    public static void log(String s ){
        System.out.println(s);
    }
}
