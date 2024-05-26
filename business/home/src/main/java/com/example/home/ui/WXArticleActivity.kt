package com.example.home.ui

import com.example.baselib.base.BaseActivity
import com.example.baselib.impl.NoMultiClickListener
import com.example.baselib.utils.AutoServiceLoaderUtil
import com.example.home.BR
import com.example.home.R
import com.example.home.databinding.ActivityWxarticleBinding
import com.example.home.model.WXArticleViewModel

/**
 *Author: chinadragon
 *Time: 2024/5/25
 */
class WXArticleActivity : BaseActivity<WXArticleViewModel, ActivityWxarticleBinding>(
    R.layout.activity_wxarticle,
    BR.mWXArticleViewModel
) {
    override fun loadData() {
        super.loadData()
        mViewModel.wxArticle()
    }

    override fun initEvent() {
        super.initEvent()
        with(binding){
            swipeRefresh.isRefreshing = false
            swipeRefresh.setOnRefreshListener {
                loadData()
            }

            tvLogin.setOnClickListener(NoMultiClickListener{
                AutoServiceLoaderUtil.loadApp()?.startLoginActivity(this@WXArticleActivity)
                finish()
            })
        }


        mViewModel.wxArticleLiveData.observe(this) {
            binding.swipeRefresh.isRefreshing = false
        }
    }
}