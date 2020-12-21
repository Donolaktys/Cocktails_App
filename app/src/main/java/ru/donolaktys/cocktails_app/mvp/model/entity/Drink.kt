package ru.donolaktys.cocktails_app.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class Drink(
    @Expose val idDrink: String? = null,
    @Expose val strDrink:String? = null,
    @Expose val strInstructions: String? = null,
    @Expose val strDrinkThumb: String? = null
): Parcelable
