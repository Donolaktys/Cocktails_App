package ru.donolaktys.cocktails_app.mvp.model.repo

import io.reactivex.rxjava3.schedulers.Schedulers
import ru.donolaktys.cocktails_app.mvp.model.api.IDataSource

class RetrofitDrinksRepo(val api: IDataSource) : IDrinksRepo {

    override fun getDrinks() = api.getRandom().subscribeOn(Schedulers.io())

}