package com.project.iris.model

import com.squareup.moshi.Json

class ReceiptData {

  @Json(name = "cash_tendered")
  var cashTendered: Int? = null
  @Json(name = "tax")
  var tax: Int? = null
  @Json(name = "items")
  var receiptItems: List<ReceiptItem>? = null
  @Json(name = "subtotal")
  var subtotal: Int? = null
  @Json(name = "change")
  var change: Int? = null
  @Json(name = "total")
  var total: Int? = null
  @Json(name = "currency")
  var currency: String? = null
  @Json(name = "date_added")
  var dateAdded: String? = null

}
