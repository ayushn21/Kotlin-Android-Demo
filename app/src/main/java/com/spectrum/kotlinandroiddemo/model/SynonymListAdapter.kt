package com.spectrum.kotlinandroiddemo.model

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.spectrum.kotlinandroiddemo.R
import kotlinx.android.synthetic.main.item_synonym_list.view.*
import org.jetbrains.anko.layoutInflater

/**
 * Created by Ayush on 05/06/16.
 */

class SynonymListAdapter(context: Context, items: Array<String>):
        ArrayAdapter<String>(context, 0, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemView: View
        if (convertView == null) {
            itemView = context.layoutInflater.inflate(R.layout.item_synonym_list, parent, false)
        }
        else {
            itemView = convertView
        }

        itemView.synonymListItemTextView.text = getItem(position)

        return itemView
    }
}