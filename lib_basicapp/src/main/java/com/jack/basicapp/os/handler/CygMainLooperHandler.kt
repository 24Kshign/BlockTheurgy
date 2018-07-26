package com.jack.basicapp.os.handler

import android.os.Looper


/**
 * Created by manji
 * Date：2018/7/20 下午3:20
 * Desc：
 */

class CygMainLooperHandler() : CygHandler(Looper.getMainLooper()) {
    private object Singleton {
        val INSTANCE = CygMainLooperHandler()
    }

    companion object {
        val instance by lazy { Singleton.INSTANCE }
    }
}