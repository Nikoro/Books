package com.dominikkrajcer.books.di

import com.dominikkrajcer.books.data.repository.BooksRepository
import com.dominikkrajcer.books.data.repository.BooksRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    single<BooksRepository>(createdAtStart = true) { BooksRepositoryImpl(get()) }

}