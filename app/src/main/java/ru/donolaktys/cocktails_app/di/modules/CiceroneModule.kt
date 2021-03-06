package ru.donolaktys.cocktails_app.di.modules

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

@Module
class CiceroneModule {

    private val cicerone: Cicerone<Router> = Cicerone.create()

    @Provides
    fun cicerone(): Cicerone<Router> = cicerone

    @Provides
    fun navigatorHolder() = cicerone.navigatorHolder

    @Provides
    fun router() = cicerone.router
}