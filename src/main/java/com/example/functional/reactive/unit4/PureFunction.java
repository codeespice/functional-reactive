package com.example.functional.reactive.unit4;

public class PureFunction {
    int value =5 ;
    public int addPure (int a , int b){
        return a+b;
    }
   /*
   function reference value so with same input out put never be same
    */
    public  int  addNonPure(int a , int b){
        return value+a+b;
   }
}
