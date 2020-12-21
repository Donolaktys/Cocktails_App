package ru.donolaktys.cocktails_app.di.modules

import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import ru.donolaktys.cocktails_app.ui.App

class AppModule(val app: App) {

    @Provides
    fun uiScheduler(): Scheduler = AndroidSchedulers.mainThread()

    @Provides
    fun app() : App {
        return app
    }
}