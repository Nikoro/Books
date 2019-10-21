package com.dominikkrajcer.books.ui.screens.details

import com.dominikkrajcer.books.base.viewmodel.BaseViewModel
import com.dominikkrajcer.books.data.repository.BooksRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class DetailsViewModel(bookId: Int, private val booksRepository: BooksRepository) :
    BaseViewModel() {

    val book = booksRepository.getBy(bookId)

    fun onDeleteConfirmationButtonClicked() {
        launch {
            try {
                book.value?.let {
                    booksRepository.remove(it)
                }
            } catch (error: Throwable) {
                Timber.e(error)
            }
        }
    }
}