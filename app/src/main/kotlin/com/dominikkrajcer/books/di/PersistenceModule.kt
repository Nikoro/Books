package com.dominikkrajcer.books.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dominikkrajcer.books.common.Constants
import com.dominikkrajcer.books.data.database.BooksDatabase
import org.koin.dsl.module

val persistenceModule = module {

    single { createRoomDatabase<BooksDatabase>(get(), Constants.Database.DATABASE_NAME) }

    single { createSongDao(get()) }

}

private fun createSongDao(bookDatabase: BooksDatabase) = bookDatabase.bookDao

private inline fun <reified T : RoomDatabase> createRoomDatabase(
    context: Context,
    databaseName: String
) =
    Room.databaseBuilder(context, T::class.java, databaseName).build()


