package co.cdmunoz.screenshotapp

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import co.cdmunoz.screenshotapp.screenshot.Screenshot
import kotlinx.android.synthetic.main.activity_main.imageView
import kotlinx.android.synthetic.main.activity_main.imageViewCamera
import kotlinx.android.synthetic.main.activity_main.imageViewTrash
import kotlinx.android.synthetic.main.activity_main.mainView
import kotlinx.android.synthetic.main.activity_main.toolbar

class ScreenshotActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    setSupportActionBar(toolbar)
    supportActionBar?.setIcon(R.drawable.ic_camera)
    supportActionBar?.setLogo(R.drawable.ic_camera)
    supportActionBar?.setDisplayUseLogoEnabled(true)
    if (Build.VERSION.SDK_INT >= 24)
      supportActionBar?.title = Html.fromHtml("&nbsp;" + getString(R.string.app_name),
          Html.FROM_HTML_MODE_LEGACY)
    else
      supportActionBar?.title = Html.fromHtml("&nbsp;" + getString(R.string.app_name))

    imageViewCamera.setOnClickListener {
      removeBitmapReference()
      val bitmap = Screenshot.takeScreeshotOfRootView(imageView)
      imageView.setImageBitmap(bitmap)
      mainView.setBackgroundColor(Color.parseColor("#888888"))
    }

    imageViewTrash.setOnClickListener {
      removeBitmapReference()
      imageView.setImageResource(R.mipmap.ic_launcher_round)
    }
  }

  private fun removeBitmapReference() {
    imageView.setImageBitmap(null)
    mainView.background = null
  }
}
