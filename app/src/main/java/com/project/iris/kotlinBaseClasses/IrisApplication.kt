package com.project.iris.kotlinBaseClasses

import android.app.Application
import butterknife.BuildConfig
import butterknife.ButterKnife

/**
 * Created by RanaAli on 6/26/17.
 */

class IrisApplication: Application(){


    override fun onCreate() {
        super.onCreate()

        ButterKnife.setDebug(BuildConfig.DEBUG)

    }
}