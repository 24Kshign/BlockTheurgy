package com.jack.basicui.recyclerview

/**
 * Created by manji
 * Date：2018/7/21 下午5:33
 * Desc：
 */
interface MultiTypeAdapter<DATA> {

    fun getLayoutRes(data: DATA): Int
}