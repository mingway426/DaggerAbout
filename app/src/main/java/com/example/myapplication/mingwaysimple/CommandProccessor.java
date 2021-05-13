package com.example.myapplication.mingwaysimple;


import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayDeque;
import java.util.Deque;

import javax.inject.Inject;
import javax.inject.Singleton;


@RequiresApi(api = Build.VERSION_CODES.N)
@Singleton
public class CommandProccessor {

    private final Deque<CommandRouter> commandRouterStack = new ArrayDeque<>();

    @Inject
    public CommandProccessor(CommandRouter router) {
        commandRouterStack.push(router);
    }

    Command.Status process(String input) {
        Command.Result result = commandRouterStack.peek().Route(input);
        if(result.status().equals(Command.Status.INPUT_COMPLETED)) {
            commandRouterStack.pop();
            return commandRouterStack.isEmpty()? Command.Status.INPUT_COMPLETED: Command.Status.HANDLED;
        }

        result.nestedCommandRouter().ifPresent(commandRouterStack::push);
        return result.status();
    }
}
