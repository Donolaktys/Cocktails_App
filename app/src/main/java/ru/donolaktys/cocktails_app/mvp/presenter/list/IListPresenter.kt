package ru.donolaktys.cocktails_app.mvp.presenter.list

import ru.donolaktys.cocktails_app.mvp.view.list.IItemView

interface IListPresenter<V: IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}