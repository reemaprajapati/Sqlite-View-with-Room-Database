package com.example.reema.myapplication.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class Student(
    @PrimaryKey
    @ColumnInfo(name = "student_id")
    var studentId: Int,
    @ColumnInfo(name = "student_name")
    var studentName: String,
    @ColumnInfo(name = "class")
    var grade: Int
)