package com.example.functional.reactive.unit5.command;

import java.util.function.Consumer;

public class Remote {
Command command;
    public void setCommand(Command command){
        this.command=command;
    }
    public void execute(){
        command.execute();
    }
}
