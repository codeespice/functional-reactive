package com.example.functional.reactive.unit4;

@FunctionalInterface
public interface Function<T,R> {
    public R doAction(T t);

    default <V> Function<V,R> andThen(Function<V,T> before){
      /*  return (V v)-> {
        T t =   before.doAction(v);
         return this.doAction(t);
        };*/
        //or
        return (V v)->doAction(before.doAction(v));
    }
}
