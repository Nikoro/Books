package com.dominikkrajcer.books.ui.screens.home

import com.dominikkrajcer.books.base.viewmodel.BaseViewModel
import com.dominikkrajcer.books.data.repository.BooksRepository


class HomeViewModel(booksRepository: BooksRepository) : BaseViewModel() {

    val books = booksRepository.books

}