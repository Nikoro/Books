package com.dominikkrajcer.books.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.dominikkrajcer.books.base.dao.BaseDao
import com.dominikkrajcer.books.data.model.Book


@Dao
abstract class BookDao : BaseDao<Book> {

    @Query("SELECT * FROM Book ORDER BY title COLLATE NOCASE")
    abstract fun queryAll(): LiveData<List<Book>>

    @Query("SELECT * FROM Book WHERE id = :id")
    abstract fun queryById(id: Int): LiveData<Book>

}