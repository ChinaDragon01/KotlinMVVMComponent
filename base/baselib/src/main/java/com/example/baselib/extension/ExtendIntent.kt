package com.example.baselib.extension

import android.app.Activity
import android.content.Context
import android.content.Intent

/**
 *Author: chinadragon
 *Time: 2024/5/26
 */
inline fun Intent.addNewTask(context: Context) {
    if (context !is Activity) {
        this.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
}