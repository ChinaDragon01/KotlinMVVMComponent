package com.example.home.model

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.example.baselib.base.BaseAndroidViewModel
import com.example.home.adapter.WXArticleAdapter
import com.example.home.respository.WXArticleRespository

/**
 *Author: chinadragon
 *Time: 2024/5/25
 */
class WXArticleViewModel(application: Application) :
    BaseAndroidViewModel<WXArticleRespository>(application) {
    val wxArticleAdapter = ObservableField(WXArticleAdapter())
    val wxArticleLiveData = MutableLiveData<Boolean>()

    fun wxArticle() {

        launchApiCall({ repository.wxArticle() }, successCallBack = {
            wxArticleLiveData.postValue(true)
            if (it.data == null) {
                return@launchApiCall
            }
            wxArticleAdapter.get()?.setData(it.data!!)

        }, errorCallBack = {
            wxArticleLiveData.postValue(false)

        }, exceptionCallBack = {
            wxArticleLiveData.postValue(false)

        })

        //演示使用rxjava3
//        wrapObservable(repository.wxArticle2()).subscribe(object :
//            Observer<ApiResponse<List<WXArticleBean>?>> {
//            override fun onSubscribe(d: Disposable) {
//                listDisposable.add(d)
//            }
//
//            override fun onError(e: Throwable) {
//            }
//
//            override fun onComplete() {
//            }
//
//            override fun onNext(response: ApiResponse<List<WXArticleBean>?>) {
//                if (response.data == null) {
//                    return
//                }
//                wxArticleAdapter.get()?.setData(response.data!!)
//
//            }
//
//        })
    }
}