package com.jack.basicapp.util

import android.util.Log

/**
 * Created by manji
 * Date：2018/7/20 下午2:58
 * Desc：
 */
object CygLog {

    private var sLogLevel = Log.DEBUG

    fun setLogLevel(logLevel: Int) {
        sLogLevel = logLevel
    }

    /***********************************************************************************************
     * 有tag
     */

    // msg
    fun v(tag: String, msg: String): Int {
        return log(Log.VERBOSE, tag, msg, null)
    }

    fun d(tag: String, msg: String): Int {
        return log(Log.DEBUG, tag, msg, null)
    }

    fun i(tag: String, msg: String): Int {
        return log(Log.INFO, tag, msg, null)
    }

    fun w(tag: String, msg: String): Int {
        return log(Log.WARN, tag, msg, null)
    }

    fun e(tag: String, msg: String): Int {
        return log(Log.ERROR, tag, msg, null)
    }

    // tr
    fun v(tag: String, tr: Throwable): Int {
        return log(Log.VERBOSE, tag, "", tr)
    }

    fun d(tag: String, tr: Throwable): Int {
        return log(Log.DEBUG, tag, "", tr)
    }

    fun i(tag: String, tr: Throwable): Int {
        return log(Log.INFO, tag, "", tr)
    }

    fun w(tag: String, tr: Throwable): Int {
        return log(Log.WARN, tag, "", tr)
    }

    fun e(tag: String, tr: Throwable): Int {
        return log(Log.ERROR, tag, "", tr)
    }

    // msg, tr
    fun v(tag: String, msg: String, tr: Throwable): Int {
        return log(Log.VERBOSE, tag, msg, tr)
    }

    fun d(tag: String, msg: String, tr: Throwable): Int {
        return log(Log.DEBUG, tag, msg, tr)
    }

    fun i(tag: String, msg: String, tr: Throwable): Int {
        return log(Log.INFO, tag, msg, tr)
    }

    fun w(tag: String, msg: String, tr: Throwable): Int {
        return log(Log.WARN, tag, msg, tr)
    }

    fun e(tag: String, msg: String, tr: Throwable): Int {
        return log(Log.ERROR, tag, msg, tr)
    }

    /***********************************************************************************************
     * 无tag，从栈信息里获取当前class生成tag，还有method，line信息
     */

    // 无参数
    fun verbose(): Int {
        return log(Log.VERBOSE, null, "", null)
    }

    fun debug(): Int {
        return log(Log.DEBUG, null, "", null)
    }

    fun info(): Int {
        return log(Log.INFO, null, "", null)
    }

    fun warn(): Int {
        return log(Log.WARN, null, "", null)
    }

    fun error(): Int {
        return log(Log.ERROR, null, "", null)
    }

    // msg
    fun verbose(msg: String): Int {
        return log(Log.VERBOSE, null, msg, null)
    }

    fun debug(msg: String): Int {
        return log(Log.DEBUG, null, msg, null)
    }

    fun info(msg: String): Int {
        return log(Log.INFO, null, msg, null)
    }

    fun warn(msg: String): Int {
        return log(Log.WARN, null, msg, null)
    }

    fun error(msg: String): Int {
        return log(Log.ERROR, null, msg, null)
    }

    // tr
    fun verbose(tr: Throwable): Int {
        return log(Log.VERBOSE, null, "", tr)
    }

    fun debug(tr: Throwable): Int {
        return log(Log.DEBUG, null, "", tr)
    }

    fun info(tr: Throwable): Int {
        return log(Log.INFO, null, "", tr)
    }

    fun warn(tr: Throwable): Int {
        return log(Log.WARN, null, "", tr)
    }

    fun error(tr: Throwable): Int {
        return log(Log.ERROR, null, "", tr)
    }

    // msg, tr
    fun verbose(msg: String, tr: Throwable): Int {
        return log(Log.VERBOSE, null, msg, tr)
    }

    fun debug(msg: String, tr: Throwable): Int {
        return log(Log.DEBUG, null, msg, tr)
    }

    fun info(msg: String, tr: Throwable): Int {
        return log(Log.INFO, null, msg, tr)
    }

    fun warn(msg: String, tr: Throwable): Int {
        return log(Log.WARN, null, msg, tr)
    }

    fun error(msg: String, tr: Throwable): Int {
        return log(Log.ERROR, null, msg, tr)
    }

    /***********************************************************************************************
     * 无tag，从指定的栈层次里获取当前class生成tag，还有method，line信息
     */

    // 无参数
    fun verboseEx(stackLevel: Int): Int {
        return logEx(Log.VERBOSE, "", null, stackLevel)
    }

    fun debugEx(stackLevel: Int): Int {
        return logEx(Log.DEBUG, "", null, stackLevel)
    }

    fun infoEx(stackLevel: Int): Int {
        return logEx(Log.INFO, "", null, stackLevel)
    }

    fun warnEx(stackLevel: Int): Int {
        return logEx(Log.WARN, "", null, stackLevel)
    }

    fun errorEx(stackLevel: Int): Int {
        return logEx(Log.ERROR, "", null, stackLevel)
    }

    // msg
    fun verboseEx(msg: String, stackLevel: Int): Int {
        return logEx(Log.VERBOSE, msg, null, stackLevel)
    }

    fun debugEx(msg: String, stackLevel: Int): Int {
        return logEx(Log.DEBUG, msg, null, stackLevel)
    }

    fun infoEx(msg: String, stackLevel: Int): Int {
        return logEx(Log.INFO, msg, null, stackLevel)
    }

    fun warnEx(msg: String, stackLevel: Int): Int {
        return logEx(Log.WARN, msg, null, stackLevel)
    }

    fun errorEx(msg: String, stackLevel: Int): Int {
        return logEx(Log.ERROR, msg, null, stackLevel)
    }

    // tr
    fun verboseEx(tr: Throwable, stackLevel: Int): Int {
        return logEx(Log.VERBOSE, "", tr, stackLevel)
    }

    fun debugEx(tr: Throwable, stackLevel: Int): Int {
        return logEx(Log.DEBUG, "", tr, stackLevel)
    }

    fun infoEx(tr: Throwable, stackLevel: Int): Int {
        return logEx(Log.INFO, "", tr, stackLevel)
    }

    fun warnEx(tr: Throwable, stackLevel: Int): Int {
        return logEx(Log.WARN, "", tr, stackLevel)
    }

    fun errorEx(tr: Throwable, stackLevel: Int): Int {
        return logEx(Log.ERROR, "", tr, stackLevel)
    }

    // tr
    fun verboseEx(msg: String, tr: Throwable, stackLevel: Int): Int {
        return logEx(Log.VERBOSE, msg, tr, stackLevel)
    }

    fun debugEx(msg: String, tr: Throwable, stackLevel: Int): Int {
        return logEx(Log.DEBUG, msg, tr, stackLevel)
    }

    fun infoEx(msg: String, tr: Throwable, stackLevel: Int): Int {
        return logEx(Log.INFO, msg, tr, stackLevel)
    }

    fun warnEx(msg: String, tr: Throwable, stackLevel: Int): Int {
        return logEx(Log.WARN, msg, tr, stackLevel)
    }

    fun errorEx(msg: String, tr: Throwable, stackLevel: Int): Int {
        return logEx(Log.ERROR, msg, tr, stackLevel)
    }

    /***********************************************************************************************
     * log和logEx，校验日志等级
     */

    private fun isLogLevelEnable(logLevel: Int): Boolean {
        return if (CygDebugMode.isDebugMode()) {
            true
        } else logLevel >= sLogLevel
    }

    private val CALL_LOG_STACK_LEVEL = 2

    private fun log(logLevel: Int, tag: String?, msg: String, tr: Throwable?): Int {
        if (!CygDebugMode.isShowLog()) {
            return 0
        }
        if (!isLogLevelEnable(logLevel)) {
            return 0
        }
        return if (tag.isNullable()) {
            logImpl(logLevel, Throwable().stackTrace[CALL_LOG_STACK_LEVEL], msg, tr)
        } else {
            logImpl(logLevel, tag, msg, tr)
        }
    }

    val CURRENT_STACK_LEVEL = 0
    val BELOW_CURRENT_STACK_LEVEL_1 = 1
    val BELOW_CURRENT_STACK_LEVEL_2 = 2
    val BELOW_CURRENT_STACK_LEVEL_3 = 3
    val BELOW_CURRENT_STACK_LEVEL_4 = 4
    val BELOW_CURRENT_STACK_LEVEL_5 = 5
    val BELOW_CURRENT_STACK_LEVEL_6 = 6
    val BELOW_CURRENT_STACK_LEVEL_7 = 7
    val BELOW_CURRENT_STACK_LEVEL_8 = 8
    val BELOW_CURRENT_STACK_LEVEL_9 = 9

    // 无tag，从指定的栈层次里获取当前class生成tag，还有method，line信息
    private fun logEx(logLevel: Int, msg: String, tr: Throwable?, stackLevel: Int): Int {
        return if (!isLogLevelEnable(logLevel)) {
            0
        } else logImpl(logLevel, Throwable().stackTrace[CALL_LOG_STACK_LEVEL + stackLevel], msg, tr)
    }

    /***********************************************************************************************
     * logImpl
     */

    // 有tag
    private fun logImpl(logLevel: Int, tag: String?, msg: String, tr: Throwable?): Int {
        val logTag = CygLog::class.java.simpleName + "-" + tag
        val logMsg: String
        if (tr != null) {
            logMsg = msg.string() + " \n" + Log.getStackTraceString(tr)
        } else {
            logMsg = msg.string()
        }
        if (logLevel >= Log.WARN) {
            if (CygDebugMode.isDebugMode()) {
                CygLog.debug("$logTag\n==============================\n$logMsg")
            }
        }
        return Log.println(logLevel, logTag, logMsg)
    }

    // 无tag，从栈信息里获取当前class生成tag，还有method，line信息
    private fun logImpl(logLevel: Int, stackTraceElement: StackTraceElement, msg: String, tr: Throwable?): Int {
        return logImpl(logLevel, stackTraceElement.className,
                stackTraceElement.methodName + "(), Line " + stackTraceElement.lineNumber + ". " + msg.string(), tr)
    }

}