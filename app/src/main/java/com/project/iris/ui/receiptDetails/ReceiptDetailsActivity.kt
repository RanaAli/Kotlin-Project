package com.project.iris.ui.receiptDetails

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.LinearLayout
import com.project.iris.R
import com.project.iris.customViews.ReceiptView
import com.project.iris.model.Receipt

/**
 * Created by RanaAli on 8/5/17.
 */
class ReceiptDetailsActivity: AppCompatActivity(){

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContentView(R.layout.receipt_details_activity)

    var layout: LinearLayout = findViewById(R.id.receiptDetailsRootLayout) as LinearLayout

    var receiptView: ReceiptView = ReceiptView(layout)
//    var receiptView: ReceiptView = ReceiptView(applicationContext, layout)


    if(intent.hasExtra(INTENT_ITEM_DATA)){
      var receipt: Receipt = intent.extras.getParcelable(INTENT_ITEM_DATA)
      receiptView.setData(receipt, -1)
    }
  }

  companion object {
    val INTENT_ITEM_DATA: String = "itemData"

    fun getReceiptDetailsActivityIntent(activity: AppCompatActivity, receipt: Receipt): Intent {
      var intent: Intent = Intent(activity, ReceiptDetailsActivity::class.java)
      intent.putExtra(INTENT_ITEM_DATA, receipt)
      return intent
    }
  }

}