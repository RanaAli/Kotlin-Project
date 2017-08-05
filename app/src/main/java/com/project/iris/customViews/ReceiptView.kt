package com.project.iris.customViews

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.project.iris.R
import com.project.iris.model.Receipt
import com.project.iris.ui.home.ReceiptListAdapter
import com.project.iris.utils.ImageHelper

/**
 * Created by RanaAli on 6/29/17.
 */
class ReceiptView {
  var mView: View

  @BindView(R.id.receiptStoreNameTextView)
  lateinit var storeNameTextView: TextView
  @BindView(R.id.receiptStoreLocationTextView)
  lateinit var storeLocationTextView: TextView
  @BindView(R.id.receiptStoreLogoImageView)
  lateinit var storeLogoView: ImageView

  @BindView(R.id.receiptListRecyclerView)
  lateinit var recyclerView: RecyclerView

  @BindView(R.id.receiptItemCountTextView)
  lateinit var receiptItemCountTextView: TextView

  @BindView(R.id.receiptTotalTextView)
  lateinit var totalPriceTextView: TextView

  constructor(view: View) {
    mView = view

    bindView()
    setupView()
  }

  constructor(context: Context?, viewGroup: ViewGroup?) {
    var view = LayoutInflater.from(context)
        .inflate(R.layout.receipt_view, viewGroup, false)
    viewGroup?.addView(view)

    mView = view

    bindView()
    setupView()
  }

  fun setupView() {
    val mLayoutManager = LinearLayoutManager(mView.getContext())
    recyclerView.setLayoutManager(mLayoutManager)

  }

  fun bindView() {
    ButterKnife.bind(this, mView)
  }

  fun getView(): View? {
    return mView
  }

  fun setData(receipt: Receipt, limit: Int) {
    storeNameTextView.text = receipt.merchantName
    storeLocationTextView.text = "Location missing in api"

    var url = receipt?.merchantLogo
    if (url != null) {
      ImageHelper.setImage(mView.context, url, storeLogoView)
    }

    var receiptData = receipt.recepitData
    var receiptItems = receiptData?.receiptItems

//    if (receiptItems != null && receiptItems.isNotEmpty()) {
//      var itemsLeft = receiptItems.size
//
//      item1TextView.text = receiptItems[0].name
//      item1PriceTextView.text = receiptItems[0].total.toString()
//      itemsLeft--
//
//      if (receiptItems.size > 1) {
//        item2TextView.text = receiptItems[1].name
//        item2PriceTextView.text = receiptItems[1].total.toString()
//        itemsLeft--
//      }
//
//      if (receiptItems.size > 2) {
//        item3TextView.text = receiptItems[2].name
//        item3PriceTextView.text = receiptItems[2].total.toString()
//        itemsLeft--
//      }
//
//      if (itemsLeft == 0) {
//        receiptItemCountTextView.text = ""
//      } else {
//        receiptItemCountTextView.text = itemsLeft.toString() + " items left..."
//      }
//    }

    if (receiptItems != null) {
      var itemAdapter: ReceiptListAdapter = ReceiptListAdapter(receiptItems)
      recyclerView.adapter = itemAdapter
    }

    totalPriceTextView.text = receipt.total.toString()
  }

}