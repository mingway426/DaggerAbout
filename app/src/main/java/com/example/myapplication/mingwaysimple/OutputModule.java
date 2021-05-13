package com.example.myapplication.mingwaysimple;

import dagger.Module;
import dagger.Provides;

@Module
abstract class OutputModule {

    @Provides
    static Outputter textOutputter(){
        return System.out::println;
    }
}
