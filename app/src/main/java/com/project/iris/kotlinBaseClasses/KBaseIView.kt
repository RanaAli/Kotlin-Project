package com.project.iris.kotlinBaseClasses

import android.content.Context

/**
 * Created by RanaAli on 6/26/17.
 */
interface KBaseIView<B : KBaseIViewCallBacks> {

    fun getContext(): Context

    fun showProgress()

    fun dismissProgress()

    fun setCallBacks(callBacks: B)

    fun getCallBacks(): B

}