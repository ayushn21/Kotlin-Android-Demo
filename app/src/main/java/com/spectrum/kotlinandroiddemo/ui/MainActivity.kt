package com.spectrum.kotlinandroiddemo.com.spectrum.kotlinandroiddemo.ui

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.SpannableStringBuilder
import com.spectrum.kotlinandroiddemo.R
import com.spectrum.kotlinandroiddemo.com.spectrum.kotlinandroiddemo.model.SynonymListAdapter
import com.spectrum.kotlinandroiddemo.utils.removeSpaces
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addTextChangedListener()
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
}