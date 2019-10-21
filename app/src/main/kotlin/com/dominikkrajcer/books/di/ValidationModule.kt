package com.dominikkrajcer.books.di

import com.dominikkrajcer.books.validation.ISBNValidator
import com.dominikkrajcer.books.validation.ThirteenDigitISBNValidator
import org.koin.dsl.module

val validationModule = module {

    factory<ISBNValidator> { ThirteenDigitISBNValidator() }

}