package com.example.myapplication.mingwaysimple;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

/** Commands that are only applicable when a user is logged in. */
@Module
interface UserCommandsModule {
    @Binds
    @IntoMap
    @StringKey("deposit")
    Command deposit(DepositCommand command);
}