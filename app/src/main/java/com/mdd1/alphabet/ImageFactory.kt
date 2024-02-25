package com.mdd1.alphabet

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.NonDisposableHandle.parent
import java.security.AccessController.getContext

class ImageFactory (res: Resources, width: Int) {
    var res = res
    var width = width
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

    fun loadImage(i: Int): Bitmap {

        val options = BitmapFactory.Options()
        options.inScaled = true
        options.inTargetDensity = width

        val bitmap = BitmapFactory.decodeResource(res, images[i], options)
        return bitmap
    }
}

class Image(val name: String)