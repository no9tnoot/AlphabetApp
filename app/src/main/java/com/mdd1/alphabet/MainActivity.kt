package com.mdd1.alphabet

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var i = 0

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.main, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.overview -> {
                var intent = Intent(applicationContext, OverviewActivity::class.java)
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val images = arrayOf(
            R.drawable.slide01,
            R.drawable.slide02,
            R.drawable.slide03,
            R.drawable.slide04,
            R.drawable.slide05,
            R.drawable.slide06,
            R.drawable.slide07,
            R.drawable.slide08,
            R.drawable.slide09,
            R.drawable.slide10,
            R.drawable.slide11,
            R.drawable.slide12,
            R.drawable.slide13,
            R.drawable.slide14,
            R.drawable.slide15,
            R.drawable.slide16,
            R.drawable.slide17,
            R.drawable.slide18,
            R.drawable.slide19,
            R.drawable.slide20,
            R.drawable.slide21,
            R.drawable.slide22,
            R.drawable.slide23,
            R.drawable.slide24,
            R.drawable.slide25,
            R.drawable.slide26,
        )

        val prev = findViewById<Button>(R.id.prev)
        val first = findViewById<Button>(R.id.first)
        val next = findViewById<Button>(R.id.next)
        val last = findViewById<Button>(R.id.last)
        val overview = findViewById<Button>(R.id.overview)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val width = imageView.width

        val fac = ImageFactory(resources,width)

        val b = intent.extras
        if (b != null) i = b.getInt("key")

        i = intent.getIntExtra("index",0)
        Thread{imageView.setImageBitmap(fac.loadImage(i))}.start()

        prev.setOnClickListener {
            if (i == 0){
                i = 25
            } else {
                i--
            }
            Thread{imageView.setImageBitmap(fac.loadImage(i))}.start()
        }

        next.setOnClickListener {
            if (i == 25){
                i = 0
            } else {
                i++
            }
            Thread{imageView.setImageBitmap(fac.loadImage(i))}.start()
        }

        first.setOnClickListener {
            i=0
            Thread{imageView.setImageBitmap(fac.loadImage(i))}.start()
        }

        last.setOnClickListener {
            i=25
            Thread{imageView.setImageBitmap(fac.loadImage(i))}.start()
        }

    }

    override fun onPause() {
        super.onPause()

        val prefs = getSharedPreferences("X", MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString("lastActivity", MainActivity::class.java.name)
        editor.putInt("lastImage", i)
        editor.apply()
    }

    override fun onResume() {
        super.onResume()    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(IMAGE_INDEX, i)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }

    companion object {
        const val IMAGE_INDEX = "imageIndex"
    }



}

