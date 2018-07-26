package com.jack.basicapp.util

import android.widget.Toast
import com.jack.basicapp.CygApplication

/**
 * Created by manji
 * Date：2018/7/20 下午1:59
 * Desc：Toast封装
 */

object CygToast {
    private var oldMsg: String? = null
    private var mToast: Toast? = null
    private var lastTime: Long = 0
    private var nextTime: Long = 0

    fun showToast(s: String) {
        if (mToast == null) {
            mToast = Toast.makeText(CygApplication.instance, s, Toast.LENGTH_SHORT)
            mToast?.show()
            lastTime = System.currentTimeMillis()
        } else {
            nextTime = System.currentTimeMillis()
            if (s == oldMsg) {
                if (nextTime - lastTime > Toast.LENGTH_SHORT) {
                    mToast!!.show()
                }
            } else {
                oldMsg = s
                mToast?.setText(s)
                mToast?.show()
            }
        }
        lastTime = nextTime
    }

    fun showToast(textRes: Int) {
        showToast(CygApplication.instance.resources.getString(textRes))
    }
}