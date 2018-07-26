package com.jack.basicapp.util

import com.jack.basicapp.BuildConfig

/**
 * Created by manji
 * Date：2018/7/20 下午3:18
 * Desc：
 */
object CygDebugMode {

    private var isDebugMode = false     //是否是测试
    private var isPreMode = false     //是否是预发

    fun isDebugMode(): Boolean {
        return isDebugMode
    }

    fun setDebugMode(debugMode: Boolean) {
        isDebugMode = debugMode
    }

    fun isPreMode(): Boolean {
        return isPreMode
    }

    fun setPreMode(preMode: Boolean) {
        isPreMode = preMode
    }

    //是否显示日志（测试和预发环境下显示）
    fun isShowLog(): Boolean {
        return isDebugMode || isPreMode || BuildConfig.DEBUG
    }

    //是否是正式环境
    fun isFormalMode(): Boolean {
        return !isPreMode && !isDebugMode
    }
}