package com.example.myapplication.mingwaysimple;

import java.util.List;

import javax.inject.Inject;


public class HelloWorldCommand implements Command{

    private Outputter outputter;

    @Inject
    public HelloWorldCommand(Outputter outputter) {
     this.outputter = outputter;
    }

    @Override
    public String key() {
        return "hello";
    }

    @Override
    public Status handleInput(List<String> command) {
        if (!command.isEmpty()) {
            return Status.INVALID;
        }
        outputter.output("world!");
        return Status.HANDLED;
    }
}
