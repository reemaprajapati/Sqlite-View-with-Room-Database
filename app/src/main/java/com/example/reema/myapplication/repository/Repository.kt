package com.example.reema.myapplication.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.reema.myapplication.data.dao.BooksDao
import com.example.reema.myapplication.data.dao.StudentDao
import com.example.reema.myapplication.data.database.TestDatabase
import com.example.reema.myapplication.data.model.StudentBookModel
import com.example.reema.myapplication.utils.completableObserver
import com.example.reema.myapplication.utils.populateBooks
import com.example.reema.myapplication.utils.populateStudent
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class Repository(var application: Application) {
    var studentDao: StudentDao? = null
    var booksDao: BooksDao? = null
    var allStudentAndBooks: LiveData<List<StudentBookModel>> = MutableLiveData()

    init {
        val db = TestDatabase.getDatabase(application)
        booksDao = db.libraryDao()
        studentDao = db.studentDao()
        allStudentAndBooks = studentDao!!.getStudentsAndBooks()
    }

    fun insertStudents() {
        Completable.fromCallable {
            studentDao?.insertAll(populateStudent())
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(completableObserver())
    }

    fun insertBooks() {
        Completable.fromCallable {
            booksDao?.insertAll(populateBooks())
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(completableObserver())
    }
}