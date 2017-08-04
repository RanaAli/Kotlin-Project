package com.project.iris.model

import com.squareup.moshi.Json

class ReceiptItem {

  @Json(name = "quantity")
  var quantity: Int? = null
  @Json(name = "discount")
  var discount: Int? = null
  @Json(name = "comment")
  var comment: String? = null
  @Json(name = "subtotal")
  var subtotal: Int? = null
  @Json(name = "total")
  var total: Int? = null
  @Json(name = "code")
  var code: String? = null
  @Json(name = "name")
  var name: String? = null

}
