package ru.donolaktys.cocktails_app.mvp.model.repo

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.donolaktys.cocktails_app.mvp.model.api.IDataSource
import ru.donolaktys.cocktails_app.mvp.model.entity.Drink
import ru.donolaktys.cocktails_app.ui.App
import javax.inject.Inject

class RetrofitDrinksRepo() : IDrinksRepo {

    @Inject lateinit var api: IDataSource

    init {
        App.component.inject(this)
    }

    override fun getRandom(): Single<Drink> = api.getRandom().flatMap {
        Single.just(it.drinks[0])
    }.subscribeOn(Schedulers.io())

}