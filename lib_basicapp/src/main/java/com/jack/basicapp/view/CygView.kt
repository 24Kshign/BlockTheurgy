package com.jack.basicapp.view

import android.content.Context
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jack.basicapp.util.CygLog

/**
 * Created by manji
 * Date：2018/7/20 下午2:51
 * Desc：
 */
object CygView {

    fun <VIEW : View> fromView(view: View): VIEW? {
        return try {
            view as VIEW
        } catch (e: Exception) {
            CygLog.error(e)
            null
        }
    }

    fun <VIEW : View> inflateLayout(context: Context, @LayoutRes layoutRes: Int, root: ViewGroup?, attachToRoot: Boolean): VIEW? {
        return try {
            val view = LayoutInflater.from(context).inflate(layoutRes, root, attachToRoot)
            fromView(view)
        } catch (e: Exception) {
            CygLog.error(e)
            null
        }
    }

    fun <VIEW : View> inflateLayout(context: Context, @LayoutRes layoutRes: Int, root: ViewGroup?): VIEW? {
        return try {
            val view = LayoutInflater.from(context).inflate(layoutRes, root, false)
            fromView(view)
        } catch (e: Exception) {
            CygLog.error(e)
            null
        }
    }

    fun <VIEW : View> inflateLayout(context: Context, @LayoutRes layoutRes: Int): VIEW? {
        return try {
            val view = LayoutInflater.from(context).inflate(layoutRes, null)
            fromView(view)
        } catch (e: Exception) {
            CygLog.error(e)
            null
        }
    }

    fun <VIEW : View> findView(view: View, @IdRes id: Int): VIEW? {
        return try {
            val child = view.findViewById<View>(id)
            fromView(child)
        } catch (e: Exception) {
            CygLog.error(e)
            null
        }
    }
}