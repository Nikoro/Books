package com.dominikkrajcer.books.ui.screens.add

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout


@BindingAdapter("text", "isValid", "error")
fun bindTextInputLayout(
    textInputLayout: TextInputLayout,
    text: String?,
    isValid: Boolean,
    error: String
) {
    textInputLayout.error = if (text.isNullOrEmpty() || isValid) "" else error
}



