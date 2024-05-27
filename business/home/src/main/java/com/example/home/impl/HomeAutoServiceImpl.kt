package com.example.home.impl

import android.content.Context
import com.example.baselib.base.BaseAutoServiceImp
import com.example.baselib.callback.AutoServiceInterface
import com.example.baselib.extension.launchActivity
import com.example.home.ui.WXArticleActivity
import com.google.auto.service.AutoService

/**
 *Author: chinadragon
 *Time: 2024/5/26
 */
@AutoService(AutoServiceInterface::class)
class HomeAutoServiceImpl : BaseAutoServiceImp() {
    override fun startWXArticleActivity(context: Context?) {
        context?.apply {
            launchActivity(WXArticleActivity::class.java)
        }
    }
}