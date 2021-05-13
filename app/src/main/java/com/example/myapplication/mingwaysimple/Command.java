package com.example.myapplication.mingwaysimple;

import java.util.List;

public interface Command {

    String key();
    Status handleInput(List<String> command);
    
    enum Status {
        INVALID,
        HANDLED
    }
}
