package com.example.reema.myapplication.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.reema.myapplication.data.entities.Student
import com.example.reema.myapplication.data.model.StudentBookModel

@Dao
abstract class StudentDao : BaseDao<Student>() {

    @Query("Select * from studentbookmodel where studentId = 2")
    abstract fun getStudentsAndBooks(): LiveData<List<StudentBookModel>>
}