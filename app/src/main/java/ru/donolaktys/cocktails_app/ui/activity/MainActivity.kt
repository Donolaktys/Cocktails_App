package ru.donolaktys.cocktails_app.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.donolaktys.cocktails_app.databinding.ActivityMainBinding
import ru.donolaktys.cocktails_app.mvp.view.IMainView

class MainActivity : AppCompatActivity(), IMainView {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}