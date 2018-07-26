package com.jack.basicui.recyclerview

import android.view.View

/**
 * Created by manji
 * Date：2018/7/21 下午5:35
 * Desc：
 */

interface RecyclerOnItemLongClickListener {
    fun click(position: Int, view: View): Boolean
}