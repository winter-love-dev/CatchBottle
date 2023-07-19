package com.season.winter.common.extention.view

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.widget.AppCompatEditText

fun EditText.onTextChangedListener(onChange: (text: String) -> Unit) {
    addTextChangedListener(object: TextWatcher {
        override fun afterTextChanged(s: Editable?) { }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int ) { }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) =
            onChange.invoke(s.toString())
    })
}

fun AppCompatEditText.onTextChangedListener(onChange: (text: String) -> Unit) {
    (this as? EditText)?.onTextChangedListener {
        onChange.invoke(it)
    }
}
