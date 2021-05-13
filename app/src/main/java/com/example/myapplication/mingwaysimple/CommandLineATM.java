package com.example.myapplication.mingwaysimple;

import java.util.Scanner;

public class CommandLineATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandRouterFactory factory = DaggerCommandRouterFactory.create();
        CommandRouter router = factory.router();
        while (scanner.hasNext()) {
            router.Route(scanner.nextLine());
        }
    }
}
