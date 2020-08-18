package cz.matejbiza.jiu_jitsuslovnik

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var helper = DataBaseHandler(this)
    var listOfMainCheckBoxes = mutableListOf<CheckBox>()
    var listOfCheckboxesTypesTechniques = mutableListOf<CheckBox>()
    // init for checkboxes to work everywhere



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val clubs = listOf("mae", "geri", "cuki")
        //users_list.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, clubs)
        //helper.insertData(1, "mae", "dopredu", "slovicko", "aa")
        //val clubs = helper.returnData()
        //users_list.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, clubs)


        showData()
       /* listView.setOnItemClickListener{parent:AdapterView<*>, view:View, position:Int, id:Long ->
            Toast.makeText(this@MainActivity, "Hey", Toast.LENGTH_LONG).show()
        }*/

        textInput.addTextChangedListener (object: TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                showData()
            }
        })
        val czjpButton = findViewById<Button>(R.id.czjpButton)
        czjpButton.setOnClickListener {
            if (czjpButton.text == "JP") {
                czjpButton.text = "CZ"
            } else {
                czjpButton.text = "JP"
            }
            showData()
        }
        val deleteButton = findViewById<ImageButton>(R.id.deleteButton)
        deleteButton.setOnClickListener {
            var editTextInput = findViewById<EditText>(R.id.textInput)
            editTextInput.setText("")
        }
        val filterBoxContainer = findViewById<LinearLayout>(R.id.filterBoxContainer)
        val filterButton = findViewById<ImageButton>(R.id.filterButton)

        // disables visibily off FilterBoxContainer
        //filterBoxContainer.visibility = View.GONE
        filterButton.setOnClickListener {
            if (filterBoxContainer.visibility == View.VISIBLE ) {
                filterBoxContainer.visibility = View.GONE
            } else {
                filterBoxContainer.visibility = View.VISIBLE
            }
        }
        // for techniques types to appear
        val filterBoxContainerForTechniques = findViewById<ScrollView>(R.id.filterBoxContainerForTechniques)
        val showTechniquesTypesButton = findViewById<ImageButton>(R.id.showTechniquesTypesButton)
        // disables visibily off FilterBoxContainer
        //filterBoxContainerForTechniques.visibility = View.GONE
        showTechniquesTypesButton.setOnClickListener {
            if (filterBoxContainerForTechniques.visibility == View.VISIBLE ) {
                filterBoxContainerForTechniques.visibility = View.GONE
            } else {
                filterBoxContainerForTechniques.visibility = View.VISIBLE
            }
        }
        // for checkboxes
        listOfMainCheckBoxes.add(0, findViewById<CheckBox>(R.id.checkBoxSlovicka))
        listOfMainCheckBoxes.add(1, findViewById<CheckBox>(R.id.checkBoxTechniky))
        listOfMainCheckBoxes.add(2, findViewById<CheckBox>(R.id.techniqueTypesSelectAll))
        listOfCheckboxesTypesTechniques = mutableListOf<CheckBox>(
            findViewById<CheckBox>(R.id.techniqueTypes1),
            findViewById<CheckBox>(R.id.techniqueTypes2),
            findViewById<CheckBox>(R.id.techniqueTypes3),
            findViewById<CheckBox>(R.id.techniqueTypes4),
            findViewById<CheckBox>(R.id.techniqueTypes5),
            findViewById<CheckBox>(R.id.techniqueTypes6),
            findViewById<CheckBox>(R.id.techniqueTypes7),
            findViewById<CheckBox>(R.id.techniqueTypes8),
            findViewById<CheckBox>(R.id.techniqueTypes9),
            findViewById<CheckBox>(R.id.techniqueTypes10),
            findViewById<CheckBox>(R.id.techniqueTypes11),
            findViewById<CheckBox>(R.id.techniqueTypes12),
            findViewById<CheckBox>(R.id.techniqueTypes13),
            findViewById<CheckBox>(R.id.techniqueTypes14)
        )
    }
    fun showData() {
        var editTextInput = findViewById<EditText>(R.id.textInput)
        val czjpButton = findViewById<Button>(R.id.czjpButton)
        val searchLanguage = czjpButton.text.toString()
        val searchVal:String = editTextInput.text.toString()
        var listView = findViewById<ListView>(R.id.listView)
        var list = helper.returnData(searchVal, searchLanguage)

        listView.adapter = MyAdapter(this, R.layout.row, list)
    }

    fun showData(view: View) {
        /*for (a in listOfMainCheckBoxes) {
            Toast.makeText(this@MainActivity, a.isChecked.toString(), Toast.LENGTH_LONG).show()
        }*/

        showData()
    }

}
