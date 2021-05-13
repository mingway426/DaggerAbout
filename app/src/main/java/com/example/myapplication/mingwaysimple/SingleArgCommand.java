package com.example.myapplication.mingwaysimple;

import java.util.Arrays;
import java.util.List;

abstract class SingleArgCommand implements Command {

    @Override
    public final Status handleInput(List<String> input) {
        return input.size() == 1 ? handleArg(input.get(0)) : Status.INVALID;
    }

    /** Handles the single argument to the command. */
    protected abstract Status handleArg(String arg);
}
