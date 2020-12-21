package ru.donolaktys.cocktails_app.di.modules

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.donolaktys.cocktails_app.mvp.model.api.IDataSource
import ru.donolaktys.cocktails_app.mvp.model.network.INetworkStatus
import ru.donolaktys.cocktails_app.ui.App
import ru.donolaktys.cocktails_app.ui.network.AndroidNetworkStatus
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {

    @Named("apiKey")
    @Provides
    fun apiKey() = "1"

    @Named("baseUrl")
    @Provides
    fun baseUrl() = "https://www.thecocktaildb.com/api/json/v1/"

    @Named("endUrl")
    @Provides
    fun endUrl() = "/search.php?f=a"

    @Named("finalUrl")
    @Provides
    fun finalUrl(@Named("baseUrl") baseUrl: String, @Named("apiKey") apikey: String, @Named("endUrl") endUrl: String): String =
        (baseUrl + apikey + endUrl)

    @Provides
    fun api(@Named("finalUrl") finalUrl: String, gson: Gson): IDataSource = Retrofit.Builder()
        .baseUrl(finalUrl)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(IDataSource::class.java)


    @Singleton
    @Provides
    fun gson() = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .excludeFieldsWithoutExposeAnnotation()
        .create()

    @Singleton
    @Provides
    fun networkStatus(app: App): INetworkStatus = AndroidNetworkStatus(app)
}