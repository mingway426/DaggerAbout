package com.example.myapplication.mingwaysimple;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
@RequiresApi(api = Build.VERSION_CODES.N)
final class CommandRouter {
    private Map<String, Command> commands = new HashMap<>();

    @Inject
    public CommandRouter(Map<String,Command> command) {
        this.commands = command;
    }


    Command.Result Route(String input) {
        List<String> inputs = split(input);
        if (inputs.isEmpty()) {
            return invalidCommand(input);
        }

        String commandKey = inputs.get(0);
        Command command = commands.get(commandKey);
        if(null == command){
            return invalidCommand(input);
        }

        Command.Result result = command.handleInput(inputs.subList(1,inputs.size()));
        if(Command.Status.INVALID == result.status()) {
            System.out.printf(commandKey + " is invalid key");
        }
        return result;
    }

    private Command.Result invalidCommand(String input) {
        System.out.println(
                String.format("couldn't understand \"%s\". please try again.", input));
        return Command.Result.invalid();
    }

    private static List<String> split(String string) {
        return Arrays.asList(string.trim().split("\\s+"));
    }
}
