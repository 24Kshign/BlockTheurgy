package com.jack.basicapp.util

/**
 * Created by manji
 * Date：2018/7/20 下午2:41
 * Desc：
 */
object CygString {


    fun isNullable(vararg strings: String): Boolean {
        for (str: String in strings) {
            if (str.isNullable()){
                return true
            }
        }
        return false
    }
}