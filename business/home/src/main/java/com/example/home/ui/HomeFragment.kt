package com.example.home.ui

import android.os.Bundle
import com.example.baselib.base.BaseFragment
import com.example.home.BR
import com.example.home.R
import com.example.home.databinding.FragmentHomeBinding
import com.example.home.model.HomeViewModel

/**
 *Author: chinadragon
 *Time: 2024/5/25
 */
class HomeFragment :
    BaseFragment<HomeViewModel, FragmentHomeBinding>(R.layout.fragment_home, BR.mHomeViewModel) {
    companion object {
        fun creatHomeFragment(bundle: Bundle = Bundle()): HomeFragment {
            var bundle = Bundle()
            return HomeFragment().apply {
                arguments = bundle
            }
        }
    }
}