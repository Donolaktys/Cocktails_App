package ru.donolaktys.cocktails_app.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import ru.donolaktys.cocktails_app.R
import ru.donolaktys.cocktails_app.mvp.presenter.list.IAbcListPresenter
import ru.donolaktys.cocktails_app.mvp.view.list.IAbcItemView

class AbcRvAdapter(val presenter: IAbcListPresenter) :
    RecyclerView.Adapter<AbcRvAdapter.ViewHolder>() {

    inner class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), IAbcItemView,
        LayoutContainer {

        override fun setBtnText(text: Char) {
            containerView.findViewById<Button>(R.id.btn_abc).text = text.toString()
        }

        override var pos: Int = -1

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_abc_btn, parent, false)
        ).apply {
            containerView.setOnClickListener {
                presenter.itemClickListener?.invoke(this)
            }
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pos = position
        presenter.bindView(holder)
    }

    override fun getItemCount(): Int = presenter.getCount()
}