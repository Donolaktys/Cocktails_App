package ru.donolaktys.cocktails_app.mvp.presenter

import moxy.MvpPresenter
import ru.donolaktys.cocktails_app.mvp.view.IMainView
import ru.donolaktys.cocktails_app.navigation.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainPresenter : MvpPresenter<IMainView>() {

    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.StartScreen())
    }

    fun backClick() {
        router.exit()
    }
}