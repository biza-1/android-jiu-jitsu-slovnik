package cz.matejbiza.jiu_jitsuslovnik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Display
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var helper = DataBaseHandler(this)
    var listOfMainCheckBoxes = mutableListOf<CheckBox>()
    var listOfCheckboxesTypesTechniques = mutableListOf<CheckBox>()
    var listOfReturnedData = mutableListOf<Model>()
    // init for checkboxes to work everywhere



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)






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

        // shows data
        showData()
        // will open window with word details
        listView.setOnItemClickListener{parent:AdapterView<*>, view:View, position:Int, id:Long ->
            val IdOfClickedWord = listOfReturnedData[position].ID
            //Toast.makeText(this@MainActivity, IdOfClickedWord.toString(), Toast.LENGTH_LONG).show()
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("wordID",IdOfClickedWord.toString())
            startActivity(intent)
        }
    }
    fun showData() {
        var editTextInput = findViewById<EditText>(R.id.textInput)
        val czjpButton = findViewById<Button>(R.id.czjpButton)
        val searchLanguage = czjpButton.text.toString()
        val searchVal:String = editTextInput.text.toString()
        // gets chechbox data
        var checkBoxData:String = ""
        if (listOfMainCheckBoxes[0].isChecked ) {
            checkBoxData = checkBoxData.plus("'slovíčko',")
        }
        if (listOfMainCheckBoxes[1].isChecked) {
            for (a in listOfCheckboxesTypesTechniques) {
                if (a.isChecked) {
                    checkBoxData = checkBoxData.plus("'"+a.text.toString()+"',")
                }
            }
        }
        checkBoxData = checkBoxData.dropLast(1)
        // shows data
        var listView = findViewById<ListView>(R.id.listView)
        listOfReturnedData = helper.returnData(searchVal, searchLanguage,checkBoxData)
        listView.adapter = MyAdapter(this, R.layout.row, listOfReturnedData)
    }
    // for type checkboxes. When all are checked > Checked all is checked else Checked all is unchecked
    fun showData(view: View) {
        var checkedAmmount = 0
        for (a in listOfCheckboxesTypesTechniques) {
            if (a.isChecked) {
                checkedAmmount++
            }
        }
        if (checkedAmmount == listOfCheckboxesTypesTechniques.count()) {
            listOfMainCheckBoxes[2].setChecked(true)
        } else {
            listOfMainCheckBoxes[2].setChecked(false)
        }
        showData()
    }
    // when checkedall is clicked it either checks or unches all type checkboxes
    fun checkUncheckData(viev: View) {
        var boxChecked = false
        if (listOfMainCheckBoxes[2].isChecked) {
            boxChecked = true
        }
        for (a in listOfCheckboxesTypesTechniques) {
            a.setChecked(boxChecked)
        }
        showData()
    }
    // for checking/unchecking using techniqueTypesSelectAll, or changing it to make it workk
    fun changeCheckboxes() {

    }

}
