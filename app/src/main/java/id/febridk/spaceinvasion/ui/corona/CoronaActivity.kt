package id.febridk.spaceinvasion.ui.corona

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import id.febridk.spaceinvasion.R

class CoronaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_corona)
    }

    companion
    object {
        const val OPEN_CORONA = "open_corona"
    }
}