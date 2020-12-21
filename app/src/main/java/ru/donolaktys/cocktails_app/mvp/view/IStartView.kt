package ru.donolaktys.cocktails_app.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface IStartView : MvpView {
    fun init()
    fun loadInfo(name: String, description: String)
}