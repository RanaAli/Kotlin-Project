package com.project.iris.kotlinBaseClasses

import android.content.Context
import android.view.View
import butterknife.ButterKnife

/**
 * Created by RanaAli on 6/26/17.
 */

abstract class KBaseView constructor(view: View) : KBaseIView<KBaseIViewCallBacks> {

    lateinit var mViewCallback: KBaseIViewCallBacks
    var mView: View = view

    init {
        ButterKnife.bind(this, mView)
    }

    override fun getContext(): Context {
        return mView.context
    }

    override fun setCallBacks(callBacks: KBaseIViewCallBacks) {
        mViewCallback = callBacks
    }

    override fun getCallBacks(): KBaseIViewCallBacks {
        return mViewCallback
    }
}