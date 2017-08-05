package com.project.iris.ui.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.project.iris.R
import com.project.iris.model.ReceiptItem
import com.project.iris.ui.home.ReceiptListAdapter.ReceiptItemViewHolder

/**
 * Created by RanaAli on 8/5/17.
 */
class ReceiptListAdapter : RecyclerView.Adapter<ReceiptItemViewHolder> {
  var receiptItems: List<ReceiptItem>

  constructor(receiptItems: List<ReceiptItem>) : super() {
    this.receiptItems = receiptItems
  }

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ReceiptItemViewHolder {
    val itemView = LayoutInflater.from(parent?.getContext())
        .inflate(R.layout.receipt_item_view, parent, false)

    return ReceiptItemViewHolder(itemView)
  }

  override fun onBindViewHolder(holderReceiptItem: ReceiptItemViewHolder?, position: Int) {
    holderReceiptItem?.setData(receiptItems[position])
  }

  override fun getItemCount(): Int {
    return receiptItems.size
  }

  class ReceiptItemViewHolder : RecyclerView.ViewHolder {

    @BindView(R.id.receiptItemTextView)
    lateinit var name: TextView
    @BindView(R.id.receiptItemPriceTextView)
    lateinit var price: TextView

    constructor(itemView: View?) : super(itemView)

    init {
      ButterKnife.bind(this, itemView)
    }

    fun setData(item: ReceiptItem) {
      name.text = item.name
      price.text = item.total.toString()
    }
  }

}