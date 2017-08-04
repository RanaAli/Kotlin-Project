package com.project.iris.ui.home

import android.support.v4.view.ViewPager
import android.view.View
import android.widget.RelativeLayout
import butterknife.BindView
import com.project.iris.R
import com.project.iris.kotlinBaseClasses.KBaseView

/**
 * Created by RanaAli on 6/26/17.
 */

class HomeView constructor(view: View) : KBaseView(view) {

  @BindView(R.id.homeViewPager)
  lateinit var mViewPager: ViewPager

  @BindView(R.id.progressBarRelativeLayout)
  lateinit var progressBarRelativeLayout: RelativeLayout

  init {
    var drawer = DrawerView(view.findViewById(R.id.left_drawer))

    mViewPager.pageMargin = -70
    mViewPager.setPageTransformer(true, ZoomOutPageTransformer())

  }

  fun setReceiptAdapter(adaptor: HomeViewPagerAdaptor) {
    mViewPager.adapter = adaptor
  }

  override fun showProgress() {
    progressBarRelativeLayout.visibility = View.VISIBLE
  }

  override fun dismissProgress() {
    progressBarRelativeLayout.visibility = View.GONE
  }


}