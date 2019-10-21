package com.dominikkrajcer.books.validation

import com.dominikkrajcer.books.base.validator.Validator

interface ISBNValidator : Validator<String> {

    override fun isValid(ISBN: String): Boolean
}

class ThirteenDigitISBNValidator : ISBNValidator {

    override fun isValid(ISBN: String): Boolean {
        val formattedISBN = ISBN.replace("-", "").trim()

        if (formattedISBN.length != 13) return false


        val total = formattedISBN.dropLast(1)
            .map(Character::getNumericValue)
            .foldIndexed(0) { index, acc, digit ->
                acc + if (index % 2 == 0) digit else 3 * digit
            }

        var checksum = 10 - (total % 10)
        checksum = if (checksum == 10) 0 else checksum

        return checksum == formattedISBN.last().toString().toInt()
    }


}