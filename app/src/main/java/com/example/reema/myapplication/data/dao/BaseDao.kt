package com.example.reema.myapplication.data.dao

import androidx.room.Dao
import androidx.room.Insert

@Dao
abstract class BaseDao<T> {
    @Insert
    abstract fun insertAll(value: List<T>)

    @Insert
    abstract fun insert(value: T)
}