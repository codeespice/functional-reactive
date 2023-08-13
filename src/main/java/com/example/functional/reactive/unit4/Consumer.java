package com.example.functional.reactive.unit4;

import java.util.Objects;

@FunctionalInterface
public interface Consumer<T> {
   public  void doAction(T t );

   default Consumer<T> andThenAcept(Consumer<T> next){
       Objects.requireNonNull(next);
       /*return new Consumer<T>() {
           @Override
           public void doAction(T t) {
               this.doAction(t);
               next.doAction(t);
           }
       };*/
 // Or
       return (T t)->{
           this.doAction(t);
           next.doAction(t);
       };
   }
}
