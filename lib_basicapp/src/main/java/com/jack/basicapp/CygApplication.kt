package com.jack.basicapp

import android.support.multidex.MultiDexApplication

/**
 * Created by manji
 * Date：2018/7/20 下午1:59
 * Desc：Application封装
 */
open class CygApplication : MultiDexApplication() {

    companion object {
        @JvmStatic lateinit var instance: CygApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}