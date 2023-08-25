package com.example.functional.reactive.unit11;

import java.time.temporal.ValueRange;
import java.util.*;
import java.util.stream.Collectors;

public class MapFuntionalOperator {
    public static void main(String[] args){
        Map<String,String> contacts = new HashMap<>();
        contacts.put("1237589020", "John");
        contacts.put("1237009020", "John");
        contacts.put("7890291111", "Neal");
        contacts.put("2647210290", "Raju");
        contacts.put("9999999999", "Peter");
        contacts.put("9081234567", "Neha");

        System.out.println("Print all elements");
        contacts.forEach((k,v)->System.out.println("Key:"+k + " Value:"+v));

        contacts.entrySet().stream()
                .filter(contact->contact.getValue().equals("John")) //filter
                .forEach(System.out::println);

        Map<String,String> filtered =contacts.entrySet().stream()
                .filter(contact->contact.getValue().equals("John"))
                .collect(Collectors.toMap(c->c.getKey(),c->c.getValue())); //filter and return map
        System.out.println("print map of  filtered elements");
        filtered.forEach((k,v)->System.out.println("Key:"+k + " Value:"+v));


    //Join
       String namesString=  contacts.entrySet().stream()
                .map(contact->contact.getValue())
                .distinct()
                .collect(Collectors.joining(","));


        System.out.println("Names String ::" +namesString);


        //Sort
        LinkedHashMap<String,String> sortedMap =contacts.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(contact->contact.getKey(),contact->contact.getValue(),(v1,v2)->v1,LinkedHashMap::new));

        System.out.println("Sorted Map");
        sortedMap.forEach((k,v)->System.out.println("Key:"+k + " Value:"+v));

        Map<String,Double> marks = new HashMap<>();
        marks.put("Maths",78.00);
        marks.put("Science",66.00);
        marks.put("English",90.00);

        OptionalDouble average= marks.values().stream()
                .mapToDouble(element->element)
                .average();

        System.out.println("Average ::"+average);

    }
}
