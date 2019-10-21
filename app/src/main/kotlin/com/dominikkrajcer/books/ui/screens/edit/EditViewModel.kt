package com.dominikkrajcer.books.ui.screens.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dominikkrajcer.books.base.viewmodel.BaseViewModel
import com.dominikkrajcer.books.data.repository.BooksRepository
import com.dominikkrajcer.books.validation.ISBNValidator
import kotlinx.coroutines.launch
import timber.log.Timber


class EditViewModel(
    bookId: Int,
    private val booksRepository: BooksRepository,
    private val ISBNValidator: ISBNValidator
) : BaseViewModel() {

    val book = booksRepository.getBy(bookId)

    private val _isISBNValid = MutableLiveData<Boolean>(true)
    val isISBNValid: LiveData<Boolean>
        get() = _isISBNValid

    fun onEditButtonClicked() {
        launch {
            try {
                book.value?.let {
                    booksRepository.edit(it)
                }
            } catch (error: Throwable) {
                Timber.e(error)
            }
        }
    }

    fun onISBNEdiTextChanged(ISBN: String) {
        _isISBNValid.value = ISBNValidator.isValid(ISBN)
    }
}