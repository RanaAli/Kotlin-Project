package com.project.iris.kotlinBaseClasses

import android.content.Context

/**
 * Created by RanaAli on 6/26/17.
 */
interface KBaseIPresenter<V : KBaseIView<KBaseIViewCallBacks>> {

    fun attachedView(baseView: V)

    fun detachView()

    fun setViewCallbacks(viewCallback: KBaseIViewCallBacks)

    fun getContext(): Context

}