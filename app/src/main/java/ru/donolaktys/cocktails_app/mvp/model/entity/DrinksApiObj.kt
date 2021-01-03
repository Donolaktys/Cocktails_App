package ru.donolaktys.cocktails_app.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class DrinksApiObj (
    @Expose val drinks: List<Drink>
    ): Parcelable