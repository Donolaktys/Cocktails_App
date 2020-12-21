package ru.donolaktys.cocktails_app.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.donolaktys.cocktails_app.databinding.FragmentStartBinding
import ru.donolaktys.cocktails_app.mvp.model.api.IDataSource
import ru.donolaktys.cocktails_app.mvp.model.network.INetworkStatus
import ru.donolaktys.cocktails_app.mvp.model.repo.RetrofitDrinksRepo
import ru.donolaktys.cocktails_app.mvp.presenter.StartPresenter
import ru.donolaktys.cocktails_app.mvp.view.IStartView
import ru.donolaktys.cocktails_app.ui.AbcRvAdapter
import ru.donolaktys.cocktails_app.ui.App
import javax.inject.Inject

class StartFragment : MvpAppCompatFragment(), IStartView {

    lateinit var binding: FragmentStartBinding

    @Inject
    lateinit var api: IDataSource
    @Inject
    lateinit var networkStatus: INetworkStatus

    companion object {
        fun newInstance() = StartFragment()
    }

    val presenter: StartPresenter by moxyPresenter {
        StartPresenter().apply { App.component.inject(this) }
    }

    var adapter: AbcRvAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        App.component.inject(this)
        binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun init() {
        randomDrinkInit(RetrofitDrinksRepo(api))
        binding.rvAbc.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        adapter = AbcRvAdapter(presenter.abcListPresenter)
        binding.rvAbc.adapter = adapter
    }

    override fun loadInfo(name : String, description: String) {
        binding.randomTv.setText("$name/n$description")
    }

    private fun randomDrinkInit(retrofitDrinksRepo: RetrofitDrinksRepo) {
        retrofitDrinksRepo.api.getRandom().subscribeOn(Schedulers.io())
    }
}