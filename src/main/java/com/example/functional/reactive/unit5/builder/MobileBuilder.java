package com.example.functional.reactive.unit5.builder;

import java.util.function.Consumer;

public class MobileBuilder {
    int ram;
    int storage;
    int battery;
    int camera;
    String processor;
    double screenSize;
    public MobileBuilder(){

    }
    public MobileBuilder appendProperty(Consumer<MobileBuilder> consumer){

        consumer.accept(this);
        return this;
    }
    public Mobile build(){
        return new Mobile(this);
    }
}
