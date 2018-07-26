package com.jack.basicapp.util

import android.util.TypedValue
import android.widget.Toast
import com.jack.basicapp.CygApplication


/**
 * Created by jack on 2018/5/22
 */

fun Int.dp(): Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(),
        CygApplication.instance.resources.displayMetrics).toInt()

fun Int.sp(): Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, this.toFloat(),
        CygApplication.instance.resources.displayMetrics).toInt()

fun Int.px(): Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, this.toFloat(),
        CygApplication.instance.resources.displayMetrics).toInt()

fun String?.isNullable() = this == null || length == 0

fun Any?.string(): String = toString()

fun Int.isStatusSuccess(): Boolean = this == 1

fun String?.isStatusSuccess(): Boolean = !this.isNullable() && this == "1"

fun String.showToast(): Unit = Toast.makeText(CygApplication.instance,
        this, if (this.length > 5) Toast.LENGTH_LONG else Toast.LENGTH_SHORT).show()