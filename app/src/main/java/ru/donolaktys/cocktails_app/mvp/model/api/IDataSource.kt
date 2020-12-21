package ru.donolaktys.cocktails_app.mvp.model.api

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import ru.donolaktys.cocktails_app.mvp.model.entity.Drink

interface IDataSource {

    @GET("/random.php")
    fun getRandom(): Single<Drink>

}