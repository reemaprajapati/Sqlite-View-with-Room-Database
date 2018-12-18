package com.example.reema.myapplication.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.reema.myapplication.data.dao.BooksDao
import com.example.reema.myapplication.data.dao.StudentDao
import com.example.reema.myapplication.data.entities.Books
import com.example.reema.myapplication.data.entities.Student
import com.example.reema.myapplication.data.model.StudentBookModel
import com.example.reema.myapplication.utils.DATABASE_NAME

@Database(entities = [Student::class, Books::class], views = [StudentBookModel::class], version = 1)
abstract class TestDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao
    abstract fun libraryDao(): BooksDao

    companion object {
        private var INSTANCE: TestDatabase? = null
        fun getDatabase(context: Context): TestDatabase {
            if (INSTANCE == null) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        TestDatabase::class.java, DATABASE_NAME
                    )
                        .build()
                }
            }
            return INSTANCE as TestDatabase
        }
    }
}
