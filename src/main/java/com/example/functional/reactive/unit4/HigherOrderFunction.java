package com.example.functional.reactive.unit4;

public class HigherOrderFunction {
    public static void main(String args[]){
   IFactory<Integer> valFunction= createFactory(()->Math.random()*100,r->r.intValue());
   int val  = valFunction.create();
   System.out.println(val);
    }

    /*
    producer produce ,
    configrator configure produce object i.e T here
    IFactory creates the produce object T so final user uses only IFactory
    all the configuration is done inside the function
     */
    public static <T,R> IFactory<R> createFactory(IProducer<T> producer,IConfigurator<T,R> configurator){
    return ()->{
        T product = producer.produce();
       return configurator.configure(product);
    };
    }
}
