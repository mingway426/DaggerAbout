package com.example.myapplication.mingwaysimple;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
abstract class HelloWorldModule {
    @Binds
    @IntoMap
    @StringKey("hello")
    abstract Command helloWorldCommand(HelloWorldCommand command);
}
