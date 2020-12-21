package ru.donolaktys.cocktails_app.mvp.model.image

interface IImageLoader<T> {
    fun loadInto(url: String, container: T)
}