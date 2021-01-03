package ru.donolaktys.cocktails_app.di

import dagger.Component
import ru.donolaktys.cocktails_app.di.modules.*
import ru.donolaktys.cocktails_app.mvp.model.repo.RetrofitDrinksRepo
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
        RepoModule::class,
        ImageModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(startFragment: StartFragment)
    fun inject(mainPresenter: MainPresenter)
    fun inject(startPresenter: StartPresenter)
    fun inject(abcRvAdapter: AbcRvAdapter.ViewHolder)
    fun inject(retrofitDrinksRepo: RetrofitDrinksRepo)
}