package com.example.myapplication.mingwaysimple;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

final class CommandRouter {
    private Map<String, Command> commands = new HashMap<>();

    @Inject
    public CommandRouter(Map<String,Command> command) {
        this.commands = command;
    }

    Command.Status Route(String input) {
        List<String> inputs = split(input);
        if (inputs.isEmpty()) {
            return invalidCommand(input);
        }

        String commandKey = inputs.get(0);
        Command command = commands.get(commandKey);
        if(null == command){
            return invalidCommand(input);
        }

        Command.Status status = command.handleInput(inputs.subList(1,inputs.size()));
        if(Command.Status.INVALID == status) {
            System.out.printf(commandKey + " is invalid key");
        }
        return status;
    }

    private Command.Status invalidCommand(String input) {
        System.out.println(
                String.format("couldn't understand \"%s\". please try again.", input));
        return Command.Status.INVALID;
    }

    private static List<String> split(String string) {
        return Arrays.asList(string.trim().split("\\s+"));
    }
}
