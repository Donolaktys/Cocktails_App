package ru.donolaktys.cocktails_app.di.modules

import dagger.Module
import dagger.Provides
import ru.donolaktys.cocktails_app.mvp.model.api.IDataSource
import ru.donolaktys.cocktails_app.mvp.model.repo.IDrinksRepo
import ru.donolaktys.cocktails_app.mvp.model.repo.RetrofitDrinksRepo
import javax.inject.Singleton

@Module
class RepoModule {

    @Singleton
    @Provides
    fun usersRepo(api: IDataSource) : IDrinksRepo =
        RetrofitDrinksRepo(api)

}