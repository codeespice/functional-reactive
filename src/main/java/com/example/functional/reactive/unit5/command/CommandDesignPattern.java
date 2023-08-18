package com.example.functional.reactive.unit5.command;

public class CommandDesignPattern {
    public static void main(String args[]){
        AC ac = new AC();
        Remote remote = new Remote();
        /*remote.setCommand(new Command() {
            @Override
            public void execute() {
                ac.turnOn();
            }
        });*/
        remote.setCommand(()->ac.turnOn());
        remote.execute();
    }
}
