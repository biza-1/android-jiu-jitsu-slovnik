package cz.matejbiza.jiu_jitsuslovnik

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class DetailActivity: AppCompatActivity() {
    var helper = DataBaseHandler(this)
    var listOfReturnedData = mutableListOf<Model>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)



        val wordID=intent.getStringExtra("wordID")
        listOfReturnedData = helper.returnSingleData(wordID)
        var textView1 = findViewById<TextView>(R.id.textView1)
        var textView2 = findViewById<TextView>(R.id.textView2)
        var textView3 = findViewById<TextView>(R.id.textView3)
        var textView4 = findViewById<TextView>(R.id.textView4)

        textView1.text = listOfReturnedData[0].mainText
        textView2.text = listOfReturnedData[0].secondText
        textView3.text = listOfReturnedData[0].wordType
        var descripionWord = listOfReturnedData[0].Description.replace("<p>", "")
        descripionWord =  descripionWord.replace("</p>", "")
        textView4.text = descripionWord

        // gets listview
        var listView = findViewById<ListView>(R.id.listView)
        listOfReturnedData = helper.getSimilarWords(listOfReturnedData[0].mainText)
        listView.adapter = MyAdapter(this, R.layout.row, listOfReturnedData)
        
        // shows similar words
        listView.setOnItemClickListener{ parent: AdapterView<*>, view: View, position:Int, id:Long ->
            val IdOfClickedWord = listOfReturnedData[position].ID
            //Toast.makeText(this@MainActivity, IdOfClickedWord.toString(), Toast.LENGTH_LONG).show()
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("wordID",IdOfClickedWord.toString())
            startActivity(intent)
        }
        // returns to previous activity
        var backButton = findViewById<ImageButton>(R.id.backButton)
        backButton.setOnClickListener() {
            finish()
        }

    }

}
