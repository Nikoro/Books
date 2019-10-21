package com.dominikkrajcer.books.ui.screens.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dominikkrajcer.books.base.viewmodel.BaseViewModel
import com.dominikkrajcer.books.data.model.Book
import com.dominikkrajcer.books.data.repository.BooksRepository
import com.dominikkrajcer.books.validation.ISBNValidator
import kotlinx.coroutines.launch
import timber.log.Timber

class AddViewModel(
    private val booksRepository: BooksRepository,
    private val ISBNValidator: ISBNValidator
) : BaseViewModel() {

    val book = Book(title = "", author = "", ISBN = "", pageNumber = 0, rate = 3)

    private val _isISBNValid = MutableLiveData<Boolean>(false)
    val isISBNValid: LiveData<Boolean>
        get() = _isISBNValid

    fun onAddButtonClicked() {
        launch {
            try {
                booksRepository.add(book)
            } catch (error: Throwable) {
                Timber.e(error)
            }
        }
    }

    fun onISBNEdiTextChanged(ISBN: String) {
        _isISBNValid.value = ISBNValidator.isValid(ISBN)
    }
}
