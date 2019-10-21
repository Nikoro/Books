package com.dominikkrajcer.books.di


import com.dominikkrajcer.books.ui.screens.add.AddViewModel
import com.dominikkrajcer.books.ui.screens.details.DetailsViewModel
import com.dominikkrajcer.books.ui.screens.edit.EditViewModel
import com.dominikkrajcer.books.ui.screens.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { HomeViewModel(get()) }

    viewModel { (bookId: Int) -> DetailsViewModel(bookId, get()) }

    viewModel { AddViewModel(get(), get()) }

    viewModel { (bookId: Int) -> EditViewModel(bookId, get(), get()) }


}