package com.example.functional.reactive.unit4;

public class FunctionalCompositionExample {
    public static void main(String args[]){

        Function<Square,Integer> f1 = x->x.getArea();
        Function<Integer,Double> f2 = area->Math.pow(area,2);
        Function<Square,Double> f4 = f2.andThen(f1);
      double result =   f4.doAction(new Square(8));
      System.out.println(result);

           }
}
