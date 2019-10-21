package com.dominikkrajcer.books.common.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


fun Fragment.setTitle(title: String) {
    (activity as? AppCompatActivity)?.supportActionBar?.title = title
}

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}