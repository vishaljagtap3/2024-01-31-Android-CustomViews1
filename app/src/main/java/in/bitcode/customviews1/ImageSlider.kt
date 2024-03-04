package `in`.bitcode.customviews1

import android.content.Context
import android.os.AsyncTask
import android.util.AttributeSet
import android.widget.ImageView

class ImageSlider(
    context: Context,
    attributeSet: AttributeSet?
) : androidx.appcompat.widget.AppCompatImageView(context, attributeSet){

    var currentImageIndex = -1
    var delay = 1000L
    var keepRunning = true

    var imageIds : Array<Int>? = null
        set(value) {
            field = value
            start()
        }

    private fun start() {
        ImageSliderThread().execute()
    }

    private inner class ImageSliderThread : AsyncTask<Any?, Any?, Any?>() {
        override fun doInBackground(vararg params: Any?): Any? {
            while(keepRunning) {
                Thread.sleep(delay)
                publishProgress(null)
            }
            return null
        }

        override fun onProgressUpdate(vararg values: Any?) {
            super.onProgressUpdate(*values)
            if(currentImageIndex == imageIds!!.size - 1) {
                currentImageIndex = 0
            }
            else {
                ++currentImageIndex
            }
            this@ImageSlider.setImageResource(imageIds!![currentImageIndex])
        }
    }


}