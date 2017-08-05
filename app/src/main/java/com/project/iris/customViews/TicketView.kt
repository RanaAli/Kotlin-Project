package com.project.iris.customViews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.project.iris.R
import com.project.iris.model.Receipt
import com.project.iris.utils.ImageHelper

/**
 * Created by RanaAli on 6/29/17.
 */
class TicketView {
  var mView: View

  @BindView(R.id.receiptStoreNameTextView)
  lateinit var storeNameTextView: TextView
  @BindView(R.id.receiptStoreLocationTextView)
  lateinit var storeLocationTextView: TextView
  @BindView(R.id.receiptStoreLogoImageView)
  lateinit var storeLogoView: ImageView

  @BindView(R.id.receiptItem1TextView)
  lateinit var item1TextView: TextView
  @BindView(R.id.receiptItem2TextView)
  lateinit var item2TextView: TextView
  @BindView(R.id.receiptItem3TextView)
  lateinit var item3TextView: TextView

  @BindView(R.id.receiptItem1PriceTextView)
  lateinit var item1PriceTextView: TextView
  @BindView(R.id.receiptItem2PriceTextView)
  lateinit var item2PriceTextView: TextView
  @BindView(R.id.receiptItem3PriceTextView)
  lateinit var item3PriceTextView: TextView

  @BindView(R.id.receiptItemCountTextView)
  lateinit var receiptItemCountTextView: TextView

  @BindView(R.id.receiptTotalTextView)
  lateinit var totalPriceTextView: TextView

  constructor(view: View) {
    mView = view

    setupView()
    bindView()
  }

  constructor(context: Context?, viewGroup: ViewGroup?) {
    var view = LayoutInflater.from(context)
        .inflate(R.layout.ticket_view, viewGroup, false)
    viewGroup?.addView(view)

    mView = view

    setupView()
    bindView()
  }

  fun setupView() {
  }

  fun bindView() {
    ButterKnife.bind(this, mView)
  }

  fun getView(): View? {
    return mView
  }

  fun setData(receipt: Receipt) {
    storeNameTextView.text = receipt.merchantName
    storeLocationTextView.text = "Location missing in api"

    var url = receipt?.merchantLogo
    if(url != null) {
      ImageHelper.setImage(mView.context, url, storeLogoView)
    }

    var receiptData = receipt.recepitData
    var receiptItems = receiptData?.receiptItems

    if (receiptItems != null && receiptItems.isNotEmpty()) {
      var itemsLeft = receiptItems.size

      item1TextView.text = receiptItems[0].name
      item1PriceTextView.text = receiptItems[0].total.toString()
      itemsLeft--

      if (receiptItems.size > 1) {
        item2TextView.text = receiptItems[1].name
        item2PriceTextView.text = receiptItems[1].total.toString()
        itemsLeft--
      }

      if (receiptItems.size > 2) {
        item3TextView.text = receiptItems[2].name
        item3PriceTextView.text = receiptItems[2].total.toString()
        itemsLeft--
      }

      if (itemsLeft == 0) {
        receiptItemCountTextView.text = ""
      } else {
        receiptItemCountTextView.text = itemsLeft.toString() + " items left..."
      }
    }

    totalPriceTextView.text = receipt.total.toString()
  }

}