package com.jack.basicui.base

import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import cn.jake.share.frdialog.util.FRInputMethodManager
import com.jack.basicapp.util.isNullable
import com.jack.basicapp.util.string

/**
 * Created by manji
 * Date：2018/7/20 下午3:48
 * Desc：
 */

abstract class CygActivity : FragmentActivity() {

    val LOADING_TAG = "loading_tag"
    val ERROR_TAG = "error_tag"

    private var isInitTitleBar: Boolean = false

    var isLoadDataSuccess: Boolean = false

    protected abstract fun layoutRes(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (layoutRes() <= 0) {
            throw NullPointerException("请设置activity的XMl布局文件")
        }
        setContentView(layoutRes())
        initView()
        isInitTitleBar = initTitleBar()
        showLoadingLayout()
        initData()
    }

    open fun initView() {

    }

    open fun initTitleBar(): Boolean {
        return false
    }


    open fun getRootLayout(): ViewGroup? {
        return null
    }


    open fun initData() {

    }

    open fun getLoadingView(): View? {
        return null
    }

    open fun getErrorView(): View? {
        return null
    }

    private fun addViewToDecor(view: View?) {
        if (null == view || isLoadDataSuccess) {
            return
        }
        val rootView: ViewGroup?
        if (null != getRootLayout()) {
            rootView = getRootLayout()
            removeChildView(rootView, false, if (isInitTitleBar) 0 else 1)
            rootView!!.addView(view, if (isInitTitleBar) 0 else 1)
            if (rootView is RelativeLayout) {
                if (rootView.childCount > 1) {
                    val titleView = rootView.getChildAt(0)
                    val params = view.layoutParams as RelativeLayout.LayoutParams
                    params.addRule(RelativeLayout.BELOW, titleView.id)
                    view.layoutParams = params
                }
            }
        } else {
            rootView = (window.decorView as ViewGroup).getChildAt(0) as ViewGroup
            removeChildView(rootView, false)
            if (isInitTitleBar) {
                rootView.addView(view, 1)
            } else {
                //TODO 这种情况整个页面会被loading和error页面遮住（暂时没有找到比较好的方案解决）
                rootView.addView(view, 0)
            }
        }
    }

    open fun showLoadingLayout() {
        if (null != getLoadingView() && needShowLoadingView()) {
            addViewToDecor(getLoadingView())
        }
    }

    open fun showErrorLayout() {
        if (null != getErrorView()) {
            addViewToDecor(getErrorView())
        }
    }

    open fun showContentView() {
        val rootView: ViewGroup?
        if (null != getRootLayout()) {
            rootView = getRootLayout()
            removeChildView(rootView, true)
        } else {
            rootView = (window.decorView as ViewGroup).getChildAt(0) as ViewGroup
            removeChildView(rootView, true)
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

    private fun removeChildView(rootView: ViewGroup?, isVisible: Boolean) {
        removeChildView(rootView, isVisible, 0)
    }

    open fun needShowLoadingView(): Boolean {
        return true
    }

    /**
     * 点击页面中非EditText区域时，隐藏软键盘
     */
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        FRInputMethodManager.autoHideSoftInput(this, ev)
        return super.dispatchTouchEvent(ev)
    }

    override fun getResources(): Resources {
        val resources = super.getResources()
        if (Build.VERSION.SDK_INT >= 24) {
            val configuration = Configuration()
            configuration.setToDefaults()
            resources.updateConfiguration(configuration, resources.displayMetrics)
        }
        return resources
    }
}