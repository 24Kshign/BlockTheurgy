package com.jack.basicapp.os.timer

import com.jack.basicapp.os.handler.CygMainLooperHandler
import com.jack.basicapp.os.work.CygRepeatingWork
import com.jack.basicapp.os.work.CygWork
import com.jack.basicapp.util.CygLog

/**
 * Created by manji
 * Date：2018/7/20 下午3:41
 * Desc：
 */
class CygTimer : CygWork() {

    private class Work(task: Runnable, delayMillis: Long, intervalMillis: Long, repeatCount: Int) : CygRepeatingWork(task, delayMillis, intervalMillis, repeatCount) {

        private var mTimerRunnable: TimerRunnable? = null

        private inner class TimerRunnable : Runnable {
            override fun run() {
                CygLog.debug()
                runTask()
                if (mRepeatCount > 0) {
                    if (!CygMainLooperHandler.instance.postDelayed(mTimerRunnable, mIntervalMillis)) {
                        CygLog.error("main looper postDelayed error")
                    }
                }
            }
        }

        override fun startWork(): Boolean {
            mTimerRunnable = TimerRunnable()
            return CygMainLooperHandler.instance.postDelayed(mTimerRunnable, mDelayMillis)
        }

        override fun stopWork() {
            mRepeatCount = 0
            if (mTimerRunnable != null) {
                CygMainLooperHandler.instance.removeCallbacks(mTimerRunnable)
                mTimerRunnable = null
            }
        }
    }

}
