package com.dominikkrajcer.books.ui.screens.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dominikkrajcer.books.data.model.Book
import com.dominikkrajcer.books.databinding.BookItemViewBinding


class BookViewHolder private constructor(private val binding: BookItemViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(book: Book, onBookClickListener: OnBookClickListener) {
        binding.book = book
        binding.clickListener = onBookClickListener
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): BookViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = BookItemViewBinding.inflate(layoutInflater, parent, false)
            return BookViewHolder(binding)
        }
    }

}