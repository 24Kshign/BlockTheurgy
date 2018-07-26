package com.jack.basicui.recyclerview

import android.view.View

/**
 * Created by manji
 * Date：2018/7/21 下午5:34
 * Desc：
 */
interface RecyclerOnItemClickListener{
    fun click(position: Int, view: View)
}