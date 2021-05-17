package com.example.myapplication.mingwaysimple;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DataBase {
    private final Map<String, Account> accounts = new HashMap<>();

    @Inject
    public DataBase() {
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    Account getAccount(String username) {
        return accounts.computeIfAbsent(username,Account::new);
    }

    static final class Account{
        private final String username;
        private BigDecimal balance = BigDecimal.ZERO;
        Account(String username) {
            this.username = username;
        }

        String userName() {
            return username;
        }

        BigDecimal balance() {
            return balance;
        }

        void depoist(BigDecimal num) {
            this.balance = num;
        }

    }
}
