package ru.donolaktys.cocktails_app.di

import dagger.Component
import ru.donolaktys.cocktails_app.di.modules.ApiModule
import ru.donolaktys.cocktails_app.di.modules.AppModule
import ru.donolaktys.cocktails_app.di.modules.CiceroneModule
import ru.donolaktys.cocktails_app.di.modules.RepoModule
import ru.donolaktys.cocktails_app.mvp.presenter.MainPresenter
import ru.donolaktys.cocktails_app.mvp.presenter.StartPresenter
import ru.donolaktys.cocktails_app.ui.AbcRvAdapter
import ru.donolaktys.cocktails_app.ui.activity.MainActivity
import ru.donolaktys.cocktails_app.ui.fragment.StartFragment
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ApiModule::class,
        CiceroneModule::class,
        RepoModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(startFragment: StartFragment)
    fun inject(mainPresenter: MainPresenter)
    fun inject(startPresenter: StartPresenter)
    fun inject(abcRvAdapter: AbcRvAdapter.ViewHolder)
}