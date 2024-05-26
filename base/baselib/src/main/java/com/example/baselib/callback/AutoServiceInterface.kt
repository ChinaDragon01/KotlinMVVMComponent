package com.example.baselib.callback

import android.content.Context

/**
 *Author: chinadragon
 *Time: 2024/5/26
 */
interface AutoServiceInterface {
    fun startMainActivity(context: Context?)
    fun startLoginActivity(context: Context?)
    fun startWXArticleActivity(context: Context?)
}