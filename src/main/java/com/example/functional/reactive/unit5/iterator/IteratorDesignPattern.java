package com.example.functional.reactive.unit5.iterator;

public class IteratorDesignPattern {

    public static void main(String[] args){
        MyArrayList list = new MyArrayList(new Object[]{1,3,5,6,7,8});

        list.forEach(x-> System.out.println(x));
    }
}
