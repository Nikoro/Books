package com.dominikkrajcer.books.ui.screens.home

import android.view.View
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dominikkrajcer.books.data.model.Book


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, listData: List<Book>?) {
    val adapter = recyclerView.adapter as HomeListAdapter
    adapter.submitList(listData)
}

@BindingAdapter("listData")
fun bindLinearLayout(linearLayout: LinearLayout, listData: List<Book>?) {
    linearLayout.visibility = if (listData.isNullOrEmpty()) View.VISIBLE else View.GONE
}



