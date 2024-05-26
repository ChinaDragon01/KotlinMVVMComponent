package com.example.kotlinmvvmcomponent.impl

import android.content.Context
import com.example.baselib.base.BaseAutoServiceImp
import com.example.baselib.callback.AutoServiceInterface
import com.example.baselib.extension.launchActivity
import com.example.kotlinmvvmcomponent.main.ui.LoginActivity
import com.example.kotlinmvvmcomponent.main.ui.MainActivity
import com.google.auto.service.AutoService

/**
 *Author: chinadragon
 *Time: 2024/5/26
 */
@AutoService(AutoServiceInterface::class)
class AppAutoServiceImpl : BaseAutoServiceImp() {
    override fun startLoginActivity(context: Context?) {
        context?.apply {
            launchActivity(LoginActivity::class.java)
        }
    }

    override fun startMainActivity(context: Context?) {
        context?.apply {
            launchActivity(MainActivity::class.java)
        }
    }
}