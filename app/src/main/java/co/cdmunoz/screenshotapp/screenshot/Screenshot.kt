package co.cdmunoz.screenshotapp.screenshot

import android.graphics.Bitmap
import android.view.View

class Screenshot {

  companion object {
    fun takeScreenshot(view: View): Bitmap {
      view.isDrawingCacheEnabled = true
      view.buildDrawingCache(true)
      val bitmap: Bitmap = Bitmap.createBitmap(view.drawingCache)
      view.isDrawingCacheEnabled = false
      return bitmap
    }

    fun takeScreeshotOfRootView(view: View): Bitmap {
      return takeScreenshot(view.rootView)
    }
  }
}


