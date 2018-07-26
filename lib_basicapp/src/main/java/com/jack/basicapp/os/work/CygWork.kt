package com.jack.basicapp.os.work

/**
 * Created by manji
 * Date：2018/7/20 下午3:32
 * Desc：
 */
open class CygWork {

    interface Work {
        fun isWorkRunning(): Boolean
        fun startWork(): Boolean
        fun stopWork()
    }

    private var mWork: Work? = null

    protected fun start(work: Work): Boolean {
        stop()    //先停止上一次的start,为了防止多次start
        mWork = work
        return if (mWork?.startWork() == true) {
            true
        } else {
            stop()
            false
        }
    }

    fun stop() {
        if (mWork == null) {
            return
        }
        mWork?.stopWork()
        mWork = null
    }

    fun isWorking(): Boolean {
        return mWork?.isWorkRunning() ?: false
    }

}