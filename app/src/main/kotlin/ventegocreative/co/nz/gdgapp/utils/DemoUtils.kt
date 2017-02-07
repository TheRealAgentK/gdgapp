package ventegocreative.co.nz.gdgapp.utils

import android.content.Context

class DemoUtils(val myContext: Context) {

    private val assetManager = myContext.getAssets()

    fun loadJSONFromAsset(filename: String): String {

        val inputStream = assetManager.open(filename)
        val size = inputStream.available()
        val buffer = ByteArray(size)

        inputStream.read(buffer)
        inputStream.close()

        return String(buffer)
    }
}

