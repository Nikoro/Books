package com.dominikkrajcer.books.base.dao

import androidx.room.*


interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg t: T)
    
    @Update
    suspend fun update(vararg t: T)
    
    @Delete
    suspend fun delete(vararg t: T)
    
}


