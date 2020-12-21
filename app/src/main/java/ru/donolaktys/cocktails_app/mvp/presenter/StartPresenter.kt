package ru.donolaktys.cocktails_app.mvp.presenter

import android.widget.ImageView
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import moxy.MvpPresenter
import ru.donolaktys.cocktails_app.mvp.model.api.IDataSource
import ru.donolaktys.cocktails_app.mvp.model.entity.Drink
import ru.donolaktys.cocktails_app.mvp.model.image.IImageLoader
import ru.donolaktys.cocktails_app.mvp.model.repo.IDrinksRepo
import ru.donolaktys.cocktails_app.mvp.presenter.list.IAbcListPresenter
import ru.donolaktys.cocktails_app.mvp.view.IStartView
import ru.donolaktys.cocktails_app.mvp.view.list.IAbcItemView
import ru.donolaktys.cocktails_app.ui.App
import javax.inject.Inject

class StartPresenter() : MvpPresenter<IStartView>() {

    @Inject lateinit var api : IDataSource
    @Inject lateinit var imageLoader: IImageLoader<ImageView>
    @Inject lateinit var drinksRepo: IDrinksRepo
    @Inject lateinit var uiScheduler: Scheduler

    val drink: Single<Drink> by lazy { api.getRandom().subscribeOn(uiScheduler) }

    class AbcListPresenter : IAbcListPresenter {
        override var itemClickListener: ((IAbcItemView) -> Unit)? = null

        private val BTN_TEXT : Char = 'A'

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
        drink.subscribe({
            val _drink = it
            _drink.strDrink?.let { _drink.strInstructions?.let { viewState.loadInfo(_drink.strDrink, _drink.strInstructions) }}
        },{
            Single.error<Throwable>(it)
        })

//        abcListPresenter.itemClickListener = {view -> }
    }
}