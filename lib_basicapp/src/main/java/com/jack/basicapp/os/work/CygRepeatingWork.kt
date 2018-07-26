package com.jack.basicapp.os.work

import com.jack.basicapp.util.CygLog

/**
 * Created by manji
 * Date：2018/7/20 下午3:36
 * Desc：
 */
abstract class CygRepeatingWork : CygWork.Work {

    private var mTask: Runnable? = null
    protected var mDelayMillis: Long = 0
    protected var mIntervalMillis: Long = 0
    protected var mRepeatCount: Int = 0

    constructor(task: Runnable, delayMillis: Long, intervalMillis: Long, repeatCount: Int){
        mTask = task
        mDelayMillis = delayMillis
        mIntervalMillis = intervalMillis
        mRepeatCount = repeatCount
    }

    override fun isWorkRunning(): Boolean {
        return mRepeatCount > 0
    }

    protected fun runTask() {
        if (mRepeatCount <= 0) {
            CygLog.debug(javaClass.simpleName + " repeat count <= 0")
            return
        }

        val runnable = mTask
        if (runnable == null) {
            CygLog.error(javaClass.simpleName + " task is null")
            mRepeatCount = 0
            return
        }

        try {
            runnable.run()
        } catch (e: Exception) {
            CygLog.error(javaClass.simpleName + "run error", e)
        }

        if (mRepeatCount != Integer.MAX_VALUE) {
            mRepeatCount--
        }
    }
}
