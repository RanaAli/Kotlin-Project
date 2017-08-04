package com.project.iris.ui.home

import com.project.iris.kotlinBaseClasses.KBasePresenter

/**
 * Created by RanaAli on 6/26/17.
 */
class HomePresenter constructor(homeView: HomeView)
    : KBasePresenter<HomeView, HomeViewICallBacks>(homeView) {

    init {

    }

    override fun getViewCallbacks(): HomeViewICallBacks {
        return object : HomeViewICallBacks {
            override fun test() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
    }


}