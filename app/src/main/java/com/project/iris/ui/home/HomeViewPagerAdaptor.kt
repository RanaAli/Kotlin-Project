package com.project.iris.ui.home

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.iris.customViews.ReceiptView
import com.project.iris.model.Receipt


/**
 * Created by RanaAli on 6/26/17.
 */
class HomeViewPagerAdaptor(context: Context, receipt: List<Receipt>) : PagerAdapter() {
  var mContext = context
  var mReceipt: List<Receipt> = receipt
  var mLayoutInflater: LayoutInflater

  init {
    mLayoutInflater = mContext
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
  }

  override fun instantiateItem(container: ViewGroup?, position: Int): Any {
    var receiptView: ReceiptView = ReceiptView(container?.context, container)
    receiptView.setData(mReceipt[position])

    return receiptView?.getView() as Any
  }

  override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
    return view == `object` as View
  }

  override fun getCount(): Int {
    return mReceipt.size
  }

  override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) {
    container?.removeView(`object` as View)
  }

  override fun getPageTitle(position: Int): CharSequence {
    return position.toString()
  }

}