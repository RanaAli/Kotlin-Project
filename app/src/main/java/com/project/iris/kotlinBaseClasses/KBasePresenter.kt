package com.project.iris.kotlinBaseClasses

import android.content.Context

/**
 * Created by RanaAli on 6/26/17.
 */

abstract class KBasePresenter<T : KBaseIView<KBaseIViewCallBacks>, S : KBaseIViewCallBacks>
  : KBaseIPresenter<T> {

  lateinit var mBaseView: T
  var mViewCallbacks: S

  constructor(baseView: T) {
    attachedView(baseView)
    mViewCallbacks = getViewCallbacks()
    mBaseView.setCallBacks(mViewCallbacks)
  }


  override fun getContext(): Context {
    return mBaseView.getContext()
  }

  override fun attachedView(baseView: T) {
    mBaseView = baseView
  }

  override fun detachView() {
  }

  override fun getView(): T {
    return mBaseView
  }

  override fun setViewCallbacks(viewCallback: KBaseIViewCallBacks) {

  }

  abstract fun getViewCallbacks(): S


}