package com.project.iris.ui.home

import android.content.Intent
import android.os.Bundle
import com.project.iris.R
import com.project.iris.kotlinBaseClasses.KBaseActivity
import com.project.iris.model.Receipt
import com.project.iris.ui.receiptDetails.ReceiptDetailsActivity

class MainActivity : KBaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContentView(R.layout.activity_main)

    var homeView = HomeView(findViewById(R.id.homeRootDrawerLayout))
    var homePresenter = HomePresenter(homeView)
    homePresenter.callback = object : HomePresenter.HomePresenterCallback {
      override fun showReceiptDetails(receipt: Receipt) {
        startDetailsActivity(receipt)
      }
    }
    homePresenter.getReceipts()

  }

  fun startDetailsActivity(receipt: Receipt) {
    val intent: Intent = ReceiptDetailsActivity
        .getReceiptDetailsActivityIntent(this@MainActivity, receipt)
    startActivity(intent)
  }
}
