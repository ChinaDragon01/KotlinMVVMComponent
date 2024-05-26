package com.example.baselib.constant

/**
 *Author: chinadragon
 *Time: 2024/5/26
 */
import androidx.annotation.StringDef

@StringDef(
    AutoSericeImpType.APP,
    AutoSericeImpType.HOME,
    AutoSericeImpType.COMMUNITY,
    AutoSericeImpType.MINE,
)
@Target(AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class AutoSericeImpType {
    companion object {
        const val APP = "AppAutoServiceImpl"
        const val HOME = "HomeAutoServiceImpl"
        const val COMMUNITY = "CommunityAutoServiceImpl"
        const val MINE = "MineAutoServiceImpl"
    }

}