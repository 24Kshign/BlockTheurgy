package com.jack.basicui.base

import android.app.Activity
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.jack.basicapp.util.isNullable
import com.jack.basicapp.util.string

/**
 * Created by manji
 * Date：2018/7/20 下午4:09
 * Desc：
 */

abstract class CygFragment : Fragment() {

    val LOADING_TAG = "loading_tag"
    val ERROR_TAG = "error_tag"

    var isInitTitleBar: Boolean = false

    protected abstract fun layoutRes(): Int

    private lateinit var mRootView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        if (layoutRes() <= 0) {
            throw NullPointerException("请设置fragment的XMl布局文件")
        }

        mRootView = inflater.inflate(layoutRes(), null)
        onViewReallyCreated(mRootView)
        return mRootView
    }

    open fun onViewReallyCreated(view: View) {

    }

    private fun addViewToDecor(view: View?) {
        if (null != rootView()) {
            removeChildView(rootView() as ViewGroup, false, if (isInitTitleBar) 1 else 0)
            (rootView() as ViewGroup).addView(view, if (isInitTitleBar) 1 else 0)
            if (rootView() is RelativeLayout) {
                if ((rootView() as ViewGroup).childCount > 1) {
                    val titleView = (rootView() as ViewGroup).getChildAt(0)
                    val params = view!!.layoutParams as RelativeLayout.LayoutParams
                    params.addRule(RelativeLayout.BELOW, titleView.id)
                    view.layoutParams = params
                }
            }
        }
    }

    private fun removeChildView(rootView: ViewGroup?, isVisible: Boolean, start: Int) {
        if (null == rootView) {
            return
        }
        var childCount = rootView.childCount
        if (childCount > 0) {
            var i = start
            while (i < childCount) {
                val view = rootView.getChildAt(i)
                if (null != view) {
                    val objectTag = view.tag
                    if (null != objectTag && !objectTag.string().isNullable()) {
                        if (objectTag.string() == LOADING_TAG || objectTag.string() == ERROR_TAG) {
                            rootView.removeViewAt(i)
                            childCount--
                            i--
                        } else {
                            view.visibility = if (isVisible) View.VISIBLE else View.GONE
                        }
                    } else {
                        view.visibility = if (isVisible) View.VISIBLE else View.GONE
                    }
                }
                i++
            }
        }
    }

    private fun removeChildView(rootView: ViewGroup, isVisible: Boolean) {
        removeChildView(rootView, isVisible, 0)
    }

    open fun showContentView() {
        removeChildView(rootView() as ViewGroup, true)
    }

    open fun showLoadingLayout() {
        if (null != getLoadingView() && needShowLoadingView()) {
            addViewToDecor(getLoadingView())
        }
    }

    open fun getLoadingView(): View? {
        return null
    }

    open fun getErrorView(): View? {
        return null
    }

    open fun needShowLoadingView(): Boolean {
        return true
    }

    open fun showErrorLayout() {
        if (null != getErrorView()) {
            addViewToDecor(getErrorView())
        }
    }

    open fun initTitleBar(): Boolean {
        return false
    }

    fun rootView(): View? {
        return mRootView
    }

    protected fun thisActivity(): Activity? {
        return this.activity
    }

    fun <VIEW : View> findView(@IdRes id: Int): VIEW {
        return mRootView.findViewById(id)
    }
}