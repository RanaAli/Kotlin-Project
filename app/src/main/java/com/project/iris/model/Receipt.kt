package com.project.iris.model

import com.squareup.moshi.Json

class Receipt {

  @Json(name = "barcode")
  var barcode: String? = null
  @Json(name = "date_added")
  var dateAdded: String? = null
  @Json(name = "tag")
  var tag: Int? = null
  @Json(name = "total")
  var total: Int? = null
  @Json(name = "payment_type")
  var paymentType: String? = null
  @Json(name = "merchant_id")
  var merchantId: Int? = null
  @Json(name = "data")
  var recepitData: ReceiptData? = null
  @Json(name = "merchant_logo")
  var merchantLogo: String? = null
  @Json(name = "transaction_date_time")
  var transactionDateTime: String? = null
  @Json(name = "merchant_name")
  var merchantName: String? = null
  @Json(name = "id")
  var id: Int? = null
  @Json(name = "total_items")
  var totalItems: Int? = null
  @Json(name = "invoice_number")
  var invoiceNumber: String? = null
  @Json(name = "subtotal")
  var subtotal: Int? = null
  @Json(name = "merchant_sale_id")
  var merchantSaleId: Any? = null
  @Json(name = "merchant_employee_name")
  var merchantEmployeeName: String? = null

}
