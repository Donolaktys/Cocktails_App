package ru.donolaktys.cocktails_app.ui

import android.app.Application
import ru.donolaktys.cocktails_app.di.AppComponent
import ru.donolaktys.cocktails_app.di.DaggerAppComponent
import ru.donolaktys.cocktails_app.di.modules.AppModule

class App: Application() {

    companion object {
        lateinit var instance: App
        val component get() = instance._appComponent
    }

    private lateinit var _appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        _appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}