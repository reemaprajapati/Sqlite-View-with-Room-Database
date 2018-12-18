package com.example.reema.myapplication.data.dao

import androidx.room.Dao
import com.example.reema.myapplication.data.entities.Books

@Dao
abstract class BooksDao : BaseDao<Books>(){}