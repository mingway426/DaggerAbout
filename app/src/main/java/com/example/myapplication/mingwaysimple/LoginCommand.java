package com.example.myapplication.mingwaysimple;

import android.os.Build;

import androidx.annotation.RequiresApi;

import javax.inject.Inject;

public class LoginCommand extends SingleArgCommand {

    Outputter outputter;
    DataBase dataBase;

    @Inject
    public LoginCommand(DataBase dataBase,Outputter outputter) {
        this.outputter = outputter;
        this.dataBase = dataBase;
        System.out.println("Creating a new " + this);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected Status handleArg(String arg) {
        outputter.output(arg + " is logged in. with balance = " + dataBase.getAccount(arg).balance());

        return Status.HANDLED;
    }

    @Override
    public String key() {
        return "login";
    }
}
