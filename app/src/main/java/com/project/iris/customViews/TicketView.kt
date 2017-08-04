package com.project.iris.customViews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.iris.R

/**
 * Created by RanaAli on 6/29/17.
 */
class TicketView {
    var mView: View? = null

    constructor(view: View) {
        mView = view
    }

    constructor(context: Context?, viewGroup: ViewGroup?) {
        var view = LayoutInflater.from(context)
                .inflate(R.layout.ticket_view, viewGroup, false)
        viewGroup?.addView(view)
        mView = view
    }

    init {
        setupView()
        bindView()
    }

    fun setupView() {

    }

    fun bindView() {

    }

    fun getView(): View? {
        return mView
    }

}