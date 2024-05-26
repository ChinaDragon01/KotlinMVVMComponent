package com.example.baselib.utils

import com.example.baselib.callback.AutoServiceInterface
import com.example.baselib.constant.AutoSericeImpType
import java.util.ServiceLoader

/**
 *Author: chinadragon
 *Time: 2024/5/26
 */
object AutoServiceLoaderUtil {

    fun loadApp() = load(AutoServiceInterface::class.java, AutoSericeImpType.APP)

    fun loadHome() = load(AutoServiceInterface::class.java, AutoSericeImpType.HOME)

    fun loadCommunity() = load(AutoServiceInterface::class.java, AutoSericeImpType.COMMUNITY)

    fun loadMine() = load(AutoServiceInterface::class.java, AutoSericeImpType.MINE)

    fun <S> load(service: Class<S>, @AutoSericeImpType autoSericeImpType: String): S? {

        var loadServiceList = ServiceLoader.load(service)?.toList()
        if (loadServiceList.isNullOrEmpty()) {
            return null
        }

        loadServiceList.forEach {

            if (it!!::class.java.simpleName.equals(autoSericeImpType)) {
                return it
            }
        }

        return null
    }

}