package space.blazardsky.morracinese

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState :Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val playButton = findViewById<AppCompatImageButton>(R.id.playButton)
        playButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, GameActivity::class.java))
        }
    }
}