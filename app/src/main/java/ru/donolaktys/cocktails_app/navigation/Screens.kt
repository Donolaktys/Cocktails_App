package ru.donolaktys.cocktails_app.navigation

import ru.donolaktys.cocktails_app.ui.fragment.StartFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class StartScreen: SupportAppScreen() {
        override fun getFragment() = StartFragment.newInstance()
    }
}