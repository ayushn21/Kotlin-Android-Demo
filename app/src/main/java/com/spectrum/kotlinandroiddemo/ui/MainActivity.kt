package com.spectrum.kotlinandroiddemo.ui

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.SpannableStringBuilder
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.spectrum.kotlinandroiddemo.R
import com.spectrum.kotlinandroiddemo.model.SynonymListAdapter
import com.spectrum.kotlinandroiddemo.services.SynonymService
import com.spectrum.kotlinandroiddemo.utils.removeSpaces
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class MainActivity : Activity() {

    val synonymService = SynonymService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addTextChangedListener()

        synonymSubmitButton.onClick { submitButtonClicked(synonymSubmitButton) }
    }

    // Text changed listener to disable spaces from being entered
    fun addTextChangedListener() {
        synonymInputWordTextField.textChangedListener {
            afterTextChanged { sequence: Editable? ->
                val newValue = sequence?.removeSpaces() ?: SpannableStringBuilder("")
                if (newValue.toString() != sequence.toString()) {
                    synonymInputWordTextField.text = newValue
                    synonymInputWordTextField.setSelection(newValue.length)
                }
            }
        }
    }

    fun submitButtonClicked(sender: Button) {
        if (synonymInputWordTextField.text.length > 0) {
            val word = synonymInputWordTextField.text.toString()
            progressBar.visibility = View.VISIBLE
            synonymService.retrieveSynonymsForWord(word) { results ->
                synonymListView.adapter = SynonymListAdapter(this@MainActivity, results)
                progressBar.visibility = View.GONE
                synonymListView.visibility = View.VISIBLE
            }
        }
        else {
            Toast.makeText(this, R.string.empty_text_field_toast, Toast.LENGTH_SHORT).show()
        }
    }
}