package cz.matejbiza.jiu_jitsuslovnik

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class MyAdapter (var mCtx:Context, var resources:Int, var items:List<Model>):ArrayAdapter<Model>(mCtx, resources, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater:LayoutInflater = LayoutInflater.from(mCtx)
        val view:View = layoutInflater.inflate(resources, null)

        val mainText:TextView = view.findViewById(R.id.textView1)
        val secondText:TextView = view.findViewById(R.id.textView2)
        val wordType:TextView = view.findViewById(R.id.textView3)

        var mItem:Model = items[position]
        mainText.text = mItem.mainText
        secondText.text = mItem.secondText
        wordType.text = mItem.wordType

        return view
    }
}