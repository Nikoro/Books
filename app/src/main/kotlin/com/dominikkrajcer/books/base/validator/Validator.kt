package com.dominikkrajcer.books.base.validator

interface Validator<T> {

    fun isValid(t: T): Boolean

}