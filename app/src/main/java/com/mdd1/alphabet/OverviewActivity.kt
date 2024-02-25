package com.mdd1.alphabet

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.LinearLayout
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity


class OverviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overview)

        var alphabet = Array<String>(26){""}
        var j = 65

        for (i in 0..25){
            alphabet[i] = j.toChar().toString()
            j++
        }

        var adapter = ArrayAdapter<String>(applicationContext,android.R.layout.simple_dropdown_item_1line,alphabet)

        //val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)
        val gridView = findViewById<GridView>(R.id.gridView)
        gridView.adapter = adapter

        gridView.setOnItemClickListener { adapterView, view, i, l ->
            var intent = Intent(applicationContext, MainActivity::class.java)
            intent.putExtra("index",i)
            startActivity(intent)
            }

    }

    override fun onPause() {
        super.onPause()

        val prefs = getSharedPreferences("X", MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString("lastActivity", OverviewActivity::class.java.name)
        editor.apply()
    }
}