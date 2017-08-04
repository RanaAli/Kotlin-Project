package com.project.iris.ui.home

import android.support.v4.view.ViewPager
import android.view.View
import butterknife.BindView
import com.project.iris.R
import com.project.iris.kotlinBaseClasses.KBaseView

/**
 * Created by RanaAli on 6/26/17.
 */

class HomeView constructor(view: View) : KBaseView(view) {

    @BindView(R.id.homeViewPager)
    lateinit var mViewPager: ViewPager

    init {

        var drawer = DrawerView(view.findViewById(R.id.left_drawer))

        var homeAdapter = HomeViewPagerAdaptor(getContext())

        mViewPager.pageMargin = -70
        mViewPager.setPageTransformer(true, ZoomOutPageTransformer())
        mViewPager.adapter = homeAdapter

    }

    override fun showProgress() {
        TODO("not implemented") //To change body of created
        // functions use File | Settings | File Templates.
    }

    override fun dismissProgress() {
        TODO("not implemented") //To change body of created
        // functions use File | Settings | File Templates.
    }



}