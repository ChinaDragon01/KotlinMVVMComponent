package com.example.community.ui

import com.example.baselib.base.BaseFragment
import com.example.community.BR
import com.example.community.R
import com.example.community.databinding.FragmentCommunityBinding
import com.example.community.model.CommunityViewModel

/**
 *Author: chinadragon
 *Time: 2024/5/20
 */
class CommunityFragment : BaseFragment<CommunityViewModel, FragmentCommunityBinding>(
    R.layout.fragment_community,
    BR.mCommunityViewModel
) {

    override fun initData() {
        super.initData()
    }

}