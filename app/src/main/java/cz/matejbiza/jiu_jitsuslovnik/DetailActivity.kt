package cz.matejbiza.jiu_jitsuslovnik

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class DetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)
        /*val testButton = findViewById<Button>(R.id.button)
        testButton.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }
        val wordID=intent.getStringExtra("wordID")
        val text = findViewById<TextView>(R.id.textView)
        text.text = wordID*/
    }

}