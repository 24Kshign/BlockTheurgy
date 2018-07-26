package com.jack.basicui.base

import android.view.View

/**
 * Created by manji
 * Date：2018/7/20 下午4:30
 * Desc：ViewPager类型的
 */

abstract class CygViewPagerFragment : CygFragment(){

    private var isFragmentVisible: Boolean = false   //Fragment是否可见
    private var isFirstLoadData: Boolean = false  //是否第一次加载数据

    override fun onViewReallyCreated(view: View) {
        super.onViewReallyCreated(view)
        //可见，但是并没有加载过
        if (isFragmentVisible && !isFirstLoadData) {
            showLoadingLayout()
            loadData(true)
        }
    }

    /**
     * 懒加载
     */
    private fun loadData(isVisible: Boolean) {
        if (isVisible) {
            lazyLoad()
            isFirstLoadData = true
        } else {
            stopLoad()
        }
    }

    open fun lazyLoad() {

    }

    open fun stopLoad() {

    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            isFragmentVisible = true
        }
        if (null == rootView()) {
            return
        }
        onFragmentHiddenChanged(isVisibleToUser)
        //由不可见变为可见的过程，并且没有加载过数据
        if (!isFirstLoadData && isFragmentVisible) {
            isInitTitleBar = initTitleBar()
            showLoadingLayout()
            loadData(true)
            return
        }
        //已经加载过，且由可见变为不可见的过程
        if (isFragmentVisible) {
            loadData(false)
            isFragmentVisible = false
        }
    }

    open fun onFragmentHiddenChanged(isHidden: Boolean) {

    }
}