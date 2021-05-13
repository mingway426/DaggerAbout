package com.example.myapplication.mingwaysimple;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

public class DepositCommand implements Command{

    DataBase dataBase;
    Outputter outputter;

    @Inject
    public DepositCommand(DataBase dataBase,Outputter outputter) {
        this.dataBase = dataBase;
        this.outputter = outputter;
        System.out.println("Creating a new " + this);
    }




    @Override
    public String key() {
        return "deposit";
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Status handleInput(List<String> command) {
        if (command.size() != 2) {
            return Status.INVALID;
        }

        DataBase.Account account = dataBase.getAccount(command.get(0));
        account.depoist(new BigDecimal(command.get(1)));
        outputter.output(account.userName() + " now has : " +account.balance());
        return null;
    }
}
