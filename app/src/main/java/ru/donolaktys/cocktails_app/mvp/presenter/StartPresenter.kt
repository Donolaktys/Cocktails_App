package ru.donolaktys.cocktails_app.mvp.presenter

import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import moxy.MvpPresenter
import ru.donolaktys.cocktails_app.mvp.model.api.IDataSource
import ru.donolaktys.cocktails_app.mvp.model.entity.Drink
import ru.donolaktys.cocktails_app.mvp.model.repo.IDrinksRepo
import ru.donolaktys.cocktails_app.mvp.presenter.list.IAbcListPresenter
import ru.donolaktys.cocktails_app.mvp.view.IStartView
import ru.donolaktys.cocktails_app.mvp.view.list.IAbcItemView
import ru.donolaktys.cocktails_app.ui.App
import javax.inject.Inject

class StartPresenter() : MvpPresenter<IStartView>() {

    @Inject
    lateinit var api: IDataSource
    @Inject
    lateinit var drinksRepo: IDrinksRepo
    @Inject
    lateinit var uiScheduler: Scheduler

    class AbcListPresenter : IAbcListPresenter {
        override var itemClickListener: ((IAbcItemView) -> Unit)? = null

        private val BTN_TEXT: Char = 'A'

        override fun bindView(view: IAbcItemView) {
            var thisBtnText = (BTN_TEXT + view.pos)
            view.setBtnText(thisBtnText)
        }

        override fun getCount(): Int = 26

    }

    val abcListPresenter = AbcListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        App.component.inject(this)
        viewState.init()

//        abcListPresenter.itemClickListener = {view -> }
    }

    fun randomInit() {
        api.getRandom()
            .subscribeOn(uiScheduler)
            .subscribe({
                val _drink : Drink = it.drinks[0]
                _drink.strDrink?.let {
                    _drink.strInstructions?.let {
                        viewState.loadInfo(_drink.strDrink, _drink.strInstructions)
                    }
                }
                _drink.strDrinkThumb?.let {
                    viewState.loadImage(_drink.strDrinkThumb)
                }
            }, {
                Single.error<Throwable>(it)
            })
    }
}