package com.project.iris.webApi

import com.project.iris.model.Receipt
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by RanaAli on 8/4/17.
 */
public interface Api {

  @GET("transactions/{id}/")
  fun getAllReceipt(@Path("id") id: String): Observable<List<Receipt>>

}