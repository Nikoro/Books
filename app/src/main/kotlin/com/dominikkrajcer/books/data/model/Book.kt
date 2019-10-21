package com.dominikkrajcer.books.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Book(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var title: String,
    var author: String,
    var ISBN: String,
    var pageNumber: Int,
    var rate: Int
)

