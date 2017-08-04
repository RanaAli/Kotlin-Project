package com.project.iris.ui.home

import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import com.project.iris.R

/**
 * Created by RanaAli on 6/26/17.
 */

class DrawerView(view: View) {
    var mView = view



    init {
        var receiptListView = mView.findViewById(R.id.receiptsListView) as ListView
        var optionsListView = mView.findViewById(R.id.optionsListView) as ListView

        var receiptAdapter = ArrayAdapter<String>(mView.context,
                android.R.layout.simple_list_item_1,
                mView.context.resources.getStringArray(R.array.drawerReceiptType))
        receiptListView.adapter = receiptAdapter

        var optionsAdapter = ArrayAdapter<String>(mView.context,
                android.R.layout.simple_list_item_1,
                mView.context.resources.getStringArray(R.array.drawer_options))
        optionsListView.adapter = optionsAdapter
    }

}