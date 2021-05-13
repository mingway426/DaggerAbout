package com.example.myapplication.mingwaysimple;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.List;
import java.util.Optional;

@RequiresApi(api = Build.VERSION_CODES.N)
public interface Command {

    String key();
    Result handleInput(List<String> command);

    class Result {
        private final Status status;
        private final Optional<CommandRouter> nestCommandRouters;


        public Result(Status status, Optional<CommandRouter> nestCommandRouters) {
            this.status = status;
            this.nestCommandRouters = nestCommandRouters;
        }

        Optional<CommandRouter> nestedCommandRouter() {
            return nestCommandRouters;
        }

        static Result enterNestCommandSet(CommandRouter commandRouter) {
            return new Result(Status.HANDLED,Optional.of(commandRouter));
        }

        static Result invalid() {
            return new Result(Status.INVALID,Optional.empty());
        }

        static Result handled() {
            return new Result(Status.HANDLED,Optional.empty());
        }

        static Result complete() {
            return new Result(Status.INPUT_COMPLETED, Optional.empty());
        }

        Status status() {
            return status;
        }
    }

    enum Status {
        INVALID,
        HANDLED,
        INPUT_COMPLETED
    }
}
