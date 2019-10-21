package com.dominikkrajcer.books.data.repository


import androidx.lifecycle.LiveData
import com.dominikkrajcer.books.data.database.BookDao
import com.dominikkrajcer.books.data.model.Book


interface BooksRepository {

    val books: LiveData<List<Book>>

    fun getBy(bookId: Int): LiveData<Book>

    suspend fun add(book: Book)

    suspend fun remove(book: Book)

    suspend fun edit(book: Book)
}

class BooksRepositoryImpl(private val bookDao: BookDao) : BooksRepository {

    override val books = bookDao.queryAll()


    override fun getBy(bookId: Int): LiveData<Book> {
        return bookDao.queryById(bookId)
    }

    override suspend fun add(book: Book) {
        bookDao.insert(book)
    }

    override suspend fun remove(book: Book) {
        bookDao.delete(book)
    }

    override suspend fun edit(book: Book) {
        bookDao.update(book)
    }

}

