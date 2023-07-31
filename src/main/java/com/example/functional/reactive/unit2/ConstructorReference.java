package com.example.functional.reactive.unit2;

import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReference {

    public static void main(String[] args){

       Function<Runnable,Thread> threadGenerator = Thread::new; //ideally new Thread(r) -> using lambda we are using Thread::new using function so this gets Runnable
                                                                 //when calling function
       Runnable r =()-> System.out.println("Starting and ending Thread");
       Runnable r2 =()-> System.out.println("Starting and ending Thread2");
       Runnable r3 =()-> System.out.println("Starting and ending Thread3");
       Thread t1 = threadGenerator.apply(r);
       Thread t2 = threadGenerator.apply(r2);
        t1.start();
        t2.start();
        threadGenerator.apply(r3).start();
        threadGenerator.apply(()->System.out.println("Staring and Ending Thread4")).start();
    }
}
