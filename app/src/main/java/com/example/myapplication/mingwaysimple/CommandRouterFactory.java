package com.example.myapplication.mingwaysimple;

import javax.inject.Singleton;

import dagger.Component;
@Singleton
@Component(modules = {DepositModule.class, HelloWorldModule.class, LoginCommandModule.class,OutputModule.class})
public interface CommandRouterFactory {
    CommandProccessor router();
}
