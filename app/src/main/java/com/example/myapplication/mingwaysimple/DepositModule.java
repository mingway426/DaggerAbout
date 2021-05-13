package com.example.myapplication.mingwaysimple;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
abstract class DepositModule {
    @Binds
    @IntoMap
    @StringKey("deposit")
    abstract Command depositCommand(DepositCommand command);
}
