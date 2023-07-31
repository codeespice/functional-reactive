package com.example.functional.reactive.unit2;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceExample {
    public static void main(String args[]){
       List<Integer> list = List.of(1,2,3,4,5);
       Consumer<Integer> printElements = x->System.out.println(x); //-> Lambda
        Consumer<Integer> printElements2 = System.out::println; // instead of writing lambda refer to existing method
                                                                // System.out.print takes single argument and returns nothing

        printElementsFromList(list,printElements2);



        //Supplier Example

        Supplier<Double> supplierLambda = ()->Math.random(); //-> lamda theat implements supplier contract i.e methtod that does not take any parameter but returns Double
        Supplier<Double> supplierReference = Math::random;//instead of writing lambda refer to existing method i.e Math.random method takes nothing returns parameter
                                                            //Refer to static method of the class so you can write ClassName::MethodName
        System.out.println(supplierReference.get());


        BiFunction<String,String,String> bifucnlambda = (a,b)->A.staticMethod(a,b);
        BiFunction<String,String,String> bifucnReference = A::staticMethod;

        System.out.println( bifucnReference.apply("Random ","Number "));
            //Class::instanceMethod
        Function<String,Integer> functionLambda = (x)->x.length(); //Lambda that implements the method to get the length of String
        Function<String,Integer> functionReference = String::length; //Refer to class method so you can write ClassName::MethodName
        System.out.println(functionReference.apply("Random"));


        /*

        1.object::instance Method   :
                    a. Method reference of existing Object
                    b. example System.out::println
        2.Class::staticMethod   :
                    a.Static Method of Class
                    b. Example Math::random
        3.Class::instanceMethod  :
                    a. instance method of input object //here method access variables of the object example String.length on the particular string gives length of the object
                    b. example String::length

        4.Class::new  :
         */


    }

    public static <T>  void printElementsFromList(List<T> list , Consumer<T> consumer){
            for(T t : list){
                consumer.accept(t);
            }
    }
}
class A {
    public static String staticMethod(String a ,String b){
        return a+b;
    }
}
