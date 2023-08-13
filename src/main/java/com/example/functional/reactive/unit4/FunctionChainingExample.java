package com.example.functional.reactive.unit4;

import java.util.function.Function;

public class FunctionChainingExample {
    /*
    object.function1().function2()
     */
 public static void main(String[] args){
     Consumer<String> c1 = x->System.out.println(x);
     Consumer<String> c2 = x->System.out.println(x);

     Consumer<String> c3 = x-> {
         c1.doAction(x);
         c2.doAction(x);
     };
     c3.doAction("Hello");

     Consumer<String> c4 = c1.andThenAcept(c2);
     c4.doAction("Magical World");

   //  Consumer<String> c5 = c1.andThenAcept(null); //check null object


     Function<Integer , Integer> f1 = s->s+2;
     Function<Integer , Integer> f2 = s->s+2;
     Function<Integer , Integer> f3 =f1.andThen(f2);
    int result = f3.apply(6);
    System.out.println(result);
        /*
        Prefer above method instead of this
         */
     Function<Integer , Integer> f4  = x-> {

        Integer m = f1.apply(x);

         return  f2.apply(m);
     };
     System.out.println(f4.apply(10));
 }


}
