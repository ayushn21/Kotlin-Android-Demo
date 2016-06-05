package com.spectrum.kotlinandroiddemo.utils


import android.text.Editable
import android.text.SpannableStringBuilder

/**
 * Created by Ayush on 05/06/16.
 */


fun Editable.removeSpaces(): Editable {
    val newValue = this.toString().replace(" ", "")
    return  SpannableStringBuilder(newValue)
}