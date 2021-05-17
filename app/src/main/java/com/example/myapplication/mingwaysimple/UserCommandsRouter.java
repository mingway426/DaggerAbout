package com.example.myapplication.mingwaysimple;


import dagger.BindsInstance;
import dagger.Module;
import dagger.Subcomponent;

@Subcomponent(modules = UserCommandsModule.class)
interface UserCommandsRouter {
    CommandRouter router();
}