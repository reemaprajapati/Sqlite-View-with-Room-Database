package com.example.reema.myapplication.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class Books(
    @PrimaryKey
    @ColumnInfo(name = "book_id")
    var id: Int,
    @ColumnInfo(name = "student_id")
    var studentId: Int,
    @ColumnInfo(name = "book_name")
    var bookName: String,
    @ColumnInfo(name = "issue_date")
    var issueDate: String
)