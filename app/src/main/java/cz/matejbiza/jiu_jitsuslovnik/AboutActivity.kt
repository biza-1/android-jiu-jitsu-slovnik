package cz.matejbiza.jiu_jitsuslovnik

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class AboutActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_activity)

        // returns to previous activity
        var backButton = findViewById<ImageButton>(R.id.backButton)
        backButton.setOnClickListener() {
            finish()
        }
    }
}