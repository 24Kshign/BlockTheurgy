package com.jack.basicapp.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle

/**
 * Created by manji
 * Date：2018/7/20 下午1:59
 * Desc：启动Activity
 */

object CygStartActivity {

    private const val DEFAULT_FLAGS = 0

    private fun newIntent(context: Context, cls: Class<out Activity>, bundle: Bundle?, flags: Int): Intent {
        val intent = Intent(context, cls)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        intent.flags = flags
        return intent
    }

    fun start(context: Context, cls: Class<out Activity>, bundle: Bundle?, flags: Int) {
        val intent = newIntent(context, cls, bundle, flags)
        context.startActivity(intent)
    }

    fun start(context: Context, cls: Class<out Activity>, bundle: Bundle) {
        start(context, cls, bundle, DEFAULT_FLAGS)
    }

    fun start(context: Context, cls: Class<out Activity>, flags: Int) {
        start(context, cls, null, flags)
    }

    fun start(context: Context, cls: Class<out Activity>) {
        start(context, cls, null, DEFAULT_FLAGS)
    }
}
