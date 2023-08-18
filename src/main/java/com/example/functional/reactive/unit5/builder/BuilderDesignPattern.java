package com.example.functional.reactive.unit5.builder;

public class BuilderDesignPattern {
public static void main(String[] args){
    MobileBuilder mobileBuilder = new MobileBuilder();
   Mobile mobile= mobileBuilder
            .appendProperty(x->x.ram=256)
            .appendProperty(x->x.storage=100)
            .appendProperty(x->x.processor="XEON")
            .appendProperty(x->x.battery=30)
            .appendProperty(x->x.screenSize=210)
            .build();
   System.out.println(mobile);
    Mobile mobile2= mobileBuilder
            .appendProperty(x->{
                x.ram=256;
                x.storage=512;
                x.processor="XEON";
                x.battery=300;
                x.camera=20;
                x.screenSize=210;
            })
        .build();

    System.out.println(mobile2);
}
}
