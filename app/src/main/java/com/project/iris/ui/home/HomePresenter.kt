package com.project.iris.ui.home

import android.util.Log
import com.project.iris.kotlinBaseClasses.KBasePresenter
import com.project.iris.model.Receipt
import com.project.iris.repositories.ApiRepository
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by RanaAli on 6/26/17.
 */
class HomePresenter constructor(homeView: HomeView)
  : KBasePresenter<HomeView, HomeViewICallBacks>(homeView), HomeIPresenter {

  private var apiRepo: ApiRepository = ApiRepository()


  override fun getReceipts() {

    getView().showProgress()
    apiRepo.getAllReceipts("0558124206", object : Observer<List<Receipt>> {
      override fun onComplete() {
        getView().dismissProgress()
      }

      override fun onSubscribe(d: Disposable) {

      }

      override fun onNext(t: List<Receipt>) {
        getView().dismissProgress()
        var adapter = HomeViewPagerAdaptor(getView().getContext(), t)
        getView().setReceiptAdapter(adapter)
      }

      override fun onError(e: Throwable) {
        getView().dismissProgress()
        Log.e("HomePresenter", "exception" + e.toString())
      }
    })


//    var call = apiRepo.getAllReceipts("0558124206")


//    call.enqueue(object : Callback<List<Receipt>> {
//      override fun onFailure(call: Call<List<Receipt>>?, t: Throwable?) {
//        getView().dismissProgress()
//        Log.e("HomePresenter", "exception" + t.toString())
//      }
//
//      override fun onResponse(call: Call<List<Receipt>>?, response: Response<List<Receipt>>?) {
//        getView().dismissProgress()
//
//
//        if (response != null && response.isSuccessful && response.body() != null) {
//          var receipts = response.body()
//          if(receipts != null) {
//            var adapter = HomeViewPagerAdaptor(getView().getContext(), receipts)
//            getView().setReceiptAdapter(adapter)
//          }
//        }
//
//      }
//    })


  }

  override fun getViewCallbacks(): HomeViewICallBacks {
    return object : HomeViewICallBacks {
      override fun test() {
        TODO(
            "not implemented") //To change body of created functions use File | Settings | File Templates.
      }
    }
  }


}