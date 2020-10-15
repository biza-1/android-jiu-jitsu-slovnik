package cz.matejbiza.jiu_jitsuslovnik

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)

        // returns to previous activity
        var backButton = findViewById<ImageButton>(R.id.backButton)
        backButton.setOnClickListener() {
            finish()
        }
    }
}