package ru.donolaktys.cocktails_app.mvp.model.repo

import io.reactivex.rxjava3.core.Single
import ru.donolaktys.cocktails_app.mvp.model.entity.Drink

interface IDrinksRepo {
    fun getRandom() : Single<Drink>
}