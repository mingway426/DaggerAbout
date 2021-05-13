package com.example.myapplication.mingwaysimple;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Scanner;

public class CommandLineATM {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandProccessor factory = DaggerCommandRouterFactory.create().router();
        while (scanner.hasNext()) {
            factory.process(scanner.nextLine());
        }
    }
}
