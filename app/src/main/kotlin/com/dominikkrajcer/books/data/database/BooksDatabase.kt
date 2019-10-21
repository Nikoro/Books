package com.dominikkrajcer.books.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dominikkrajcer.books.data.model.Book

@Database(entities = [Book::class], version = 1)
abstract class BooksDatabase : RoomDatabase() {
    abstract val bookDao: BookDao
}