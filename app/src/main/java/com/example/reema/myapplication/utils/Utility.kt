package com.example.reema.myapplication.utils;

import android.util.Log
import com.example.reema.myapplication.data.entities.Books
import com.example.reema.myapplication.data.entities.Student
import io.reactivex.CompletableObserver
import io.reactivex.disposables.Disposable


var TAG = "Utility"
const val DATABASE_NAME = "test_database"
fun populateStudent(): List<Student> {
    return arrayOf<Student>(
        Student(1, "ram", 1),
        Student(2, "shyam", 2),
        Student(3, "hari", 3),
        Student(4, "sita", 1),
        Student(5, "gita", 2)
    ).toList()
}

fun populateBooks(): List<Books> {
    return arrayOf<Books>(
        Books(101, 2, "Maths", "2017-10-11"),
        Books(209, 2, "Science", "2018-2-1"),
        Books(123, 1, "Computer", "2018-9-1"),
        Books(234, 1, "Nepali", "2017-7-7"),
        Books(22, 3, "English", "2018-4-5")
    ).toList()
}

fun completableObserver(): CompletableObserver {
    return object : CompletableObserver {
        override fun onComplete() {
            Log.d(TAG, " transaction completed")
        }

        override fun onSubscribe(d: Disposable) {
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, " transaction error$e")
        }
    }
}
