package com.project.iris.ui.home

import android.os.Bundle
import com.project.iris.R
import com.project.iris.kotlinBaseClasses.KBaseActivity

class MainActivity : KBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        var homeView = HomeView(findViewById(R.id.homeRootDrawerLayout))
        var homePresenter = HomePresenter(homeView)

    }
}
