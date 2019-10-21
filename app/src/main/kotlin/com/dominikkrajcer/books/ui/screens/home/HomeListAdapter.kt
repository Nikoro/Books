package com.dominikkrajcer.books.ui.screens.home

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.dominikkrajcer.books.data.model.Book


class HomeListAdapter(private val onBookClickListener: OnBookClickListener) : ListAdapter<Book, BookViewHolder>(BookDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BookViewHolder.from(parent)

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(getItem(position), onBookClickListener)
    }
}


class BookDiffCallback : DiffUtil.ItemCallback<Book>() {

    override fun areItemsTheSame(oldItem: Book, newItem: Book) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Book, newItem: Book) = oldItem == newItem

}

class OnBookClickListener(val clickListener: (bookId: Int) -> Unit) {
    fun onClick(book: Book) = clickListener(book.id)
}

