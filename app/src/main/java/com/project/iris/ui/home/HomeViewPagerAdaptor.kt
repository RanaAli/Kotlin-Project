package com.project.iris.ui.home

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import com.project.iris.customViews.ReceiptView
import com.project.iris.model.Receipt


/**
 * Created by RanaAli on 6/26/17.
 */
class HomeViewPagerAdaptor(context: Context, receipt: List<Receipt>) : PagerAdapter() {
  var mContext = context
  var mReceipts: List<Receipt> = receipt
  var mLayoutInflater: LayoutInflater
  lateinit var callback: HomeViewPagerAdaptorCallback

  init {
    mLayoutInflater = mContext
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
  }

  override fun instantiateItem(container: ViewGroup?, position: Int): Any {
    var receiptView: ReceiptView = ReceiptView(container?.context, container)

    receiptView.setData(mReceipts[position], 3)
    receiptView.setClickListener(OnClickListener {
      if (callback != null) {
        callback.onReceiptClicked(mReceipts[position])
      }
    })

    return receiptView?.getView() as Any
  }

  override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
    return view == `object` as View
  }

  override fun getCount(): Int {
    return mReceipts.size
  }

  override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) {
    container?.removeView(`object` as View)
  }

  override fun getPageTitle(position: Int): CharSequence {
    return position.toString()
  }

  interface HomeViewPagerAdaptorCallback {
    fun onReceiptClicked(receipt: Receipt);
  }

}