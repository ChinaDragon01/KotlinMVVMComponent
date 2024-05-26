package com.example.kotlinmvvmcomponent.main.ui

import android.content.Intent
import com.example.baselib.base.BaseActivity
import com.example.baselib.impl.NoMultiClickListener
import com.example.baselib.utils.AutoServiceLoaderUtil
import com.example.kotlinmvvmcomponent.BR
import com.example.kotlinmvvmcomponent.R
import com.example.kotlinmvvmcomponent.databinding.ActivityLoginBinding
//import com.example.home.ui.WXArticleActivity
import com.example.kotlinmvvmcomponent.main.model.LoginViewModel

/**
 *Author: chinadragon
 *Time: 2024/5/19
 */
class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>(
    R.layout.activity_login,
    BR.mLoginViewModel
) {

    override fun initEvent() {
        super.initEvent()
        with(binding) {
            btnLookWXArticle.setOnClickListener(NoMultiClickListener {
                AutoServiceLoaderUtil.loadHome()?.startWXArticleActivity(this@LoginActivity)
//                startActivity(Intent(this@LoginActivity, WXArticleActivity::class.java))
                finish()
            })
        }

        mViewModel.loginLiveData.observe(this) {
//            if (it == null) {
//
//                return@observe
//            }
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

}