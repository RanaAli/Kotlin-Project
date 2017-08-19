package com.project.iris.utils

import android.content.Context
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by RanaAli on 6/12/17.
 */

object ImageHelper {

  fun setImage(context: Context?, url: String, imageInto: ImageView?) {
    if (imageInto != null && context != null) {
      Log.v("ImageHelper", "Loading image: " + url)
      Glide.with(context.applicationContext)
          .load(url)
          .into(imageInto)
    } else {
      Log.e("ImageHelper", "Skipped Loading image: " + url)
    }
  }
}
