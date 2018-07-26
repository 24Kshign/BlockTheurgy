package com.jack.basicapp.os.handler

import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import com.jack.basicapp.util.CygLog


/**
 * Created by manji
 * Date：2018/7/20 下午2:54
 * Desc：
 */
open class CygHandler : Handler {

    constructor() : super()

    constructor(callback: Handler.Callback) : super(callback)

    constructor(looper: Looper) : super(looper)

    constructor(looper: Looper, callback: Handler.Callback) : super(looper, callback)

    fun postDelay(runnable: Runnable, token: Any, delayMillis: Long): Boolean {
        var delayMillis = delayMillis
        CygLog.verbose("postDelayed")
        if (delayMillis < 0) {
            delayMillis = 0
        }
        return try {
            postAtTime(runnable, token, SystemClock.uptimeMillis() + delayMillis)
        } catch (e: Exception) {
            CygLog.error("postAtTime error", e)
            false
        }

    }

    fun post(runnable: Runnable, token: Any): Boolean {
        return postDelay(runnable, token, 0)
    }

}
