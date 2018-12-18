package com.example.reema.myapplication.data.model

import androidx.room.DatabaseView

@DatabaseView("Select students.student_id as studentId, students.student_name as studentName, books.book_name as bookName, books.issue_date as issueDate from students inner join books on students.student_id = books.student_id")
data class StudentBookModel(
    var studentId : Int,
    var studentName: String,
    var bookName: String,
    var issueDate: String
)