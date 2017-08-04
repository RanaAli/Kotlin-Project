package com.project.iris.repositories

import com.project.iris.conts.Constants
import com.project.iris.model.Receipt
import com.project.iris.webApi.Api
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by RanaAli on 8/4/17.
 */

class ApiRepository {

  private var retrofit: Retrofit
  private var apiService: Api

  init {

    val interceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

    retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL)
        .client(client)
        .addCallAdapterFactory(
            RxJava2CallAdapterFactory.create()).addConverterFactory(
        MoshiConverterFactory.create()).build()

    apiService = retrofit.create(Api::class.java)
  }

  fun getAllReceipts(id: String, observer: Observer<List<Receipt>>) {
    apiService.getAllReceipt(id).subscribeOn(Schedulers.io()).observeOn(
        AndroidSchedulers.mainThread()).subscribe(observer)
  }

}