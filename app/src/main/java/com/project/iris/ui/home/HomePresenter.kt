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
  lateinit var callback: HomePresenterCallback

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
        adapter.callback = object: HomeViewPagerAdaptor.HomeViewPagerAdaptorCallback{
          override fun onReceiptClicked(receipt: Receipt) {
            if(callback != null){
              callback.showReceiptDetails(receipt)
            }
          }
        }
        getView().setReceiptAdapter(adapter)
      }

      override fun onError(e: Throwable) {
        getView().dismissProgress()
        Log.e("HomePresenter", "exception" + e.toString())
      }
    })

  }

  interface HomePresenterCallback{
    fun showReceiptDetails(receipt: Receipt)
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