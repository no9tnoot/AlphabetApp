package com.mdd1.alphabet

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast


class Dispatcher : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var i: Int = try {
            val prefs = getSharedPreferences("X", MODE_PRIVATE)
            prefs.getInt("lastImage",0)
        } catch (ex: ClassNotFoundException){
            0
        }
        val activityClass: Class<*>? = try {
            val prefs = getSharedPreferences("X", MODE_PRIVATE)
            //i = prefs.getInt("lastImage",0)
            Class.forName(
                prefs.getString("lastActivity", OverviewActivity::class.java.name)
            )
        } catch (ex: ClassNotFoundException) {
            OverviewActivity::class.java

        }
        val b = Bundle()
        val intent = Intent(this, activityClass)
        b.putInt("index",i)
        intent.putExtras(b)
        startActivity(intent)
        finish()
    }
}