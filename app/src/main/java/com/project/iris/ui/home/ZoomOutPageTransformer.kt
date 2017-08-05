package com.project.iris.ui.home

import android.support.v4.view.ViewPager
import android.view.View


/**
 * Created by RanaAli on 6/29/17.
 */
class ZoomOutPageTransformer : ViewPager.PageTransformer {
//    var mView: View = view
//    var mPosition: Float = position

    override fun transformPage(page: View?, position: Float) {
        if (page != null) {
            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                page.alpha = 0f

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                val scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position))
                val vertMargin = (page.getWidth() * (1 - scaleFactor) / 2)
                val horzMargin = (page.getHeight() * (1 - scaleFactor) / 2)

                if (position < 0) {
                    page.setTranslationX(horzMargin - vertMargin / 2)
                } else {
                    page.setTranslationX(-horzMargin + vertMargin / 2)
                }

                // Scale the page down (between MIN_SCALE and 1)
                page.setScaleX(scaleFactor)
                page.setScaleY(scaleFactor)

                // Fade the page relative to its size.
//                page.alpha = (MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA))

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                page.alpha = 0f
            }
        }
    }

    companion object {
        private val MIN_SCALE = 0.85f
        private val MIN_ALPHA = 0.5f
    }
}
