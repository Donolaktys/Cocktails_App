package ru.donolaktys.cocktails_app.di

import dagger.Component
import ru.donolaktys.cocktails_app.di.modules.ApiModule
import ru.donolaktys.cocktails_app.di.modules.AppModule
import ru.donolaktys.cocktails_app.ui.activity.MainActivity
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ApiModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}