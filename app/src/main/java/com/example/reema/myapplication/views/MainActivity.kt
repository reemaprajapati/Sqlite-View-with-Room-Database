package com.example.reema.myapplication.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reema.myapplication.R
import com.example.reema.myapplication.adapters.StudentBookAdapter
import com.example.reema.myapplication.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var repo: Repository? = null
    var adapter: StudentBookAdapter? = null

    override fun onClick(v: View?) {
        when(v){
            button_insert -> {
                repo?.insertStudents()
                repo?.insertBooks()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        repo = Repository(application)
        button_insert.setOnClickListener(this)
        setUpRecyclerview()
    }

    fun setUpRecyclerview(){
        adapter = StudentBookAdapter()
        recyclerview.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerview.adapter = adapter
        fetchData()
    }

    fun fetchData(){
        repo?.allStudentAndBooks?.observe(this, Observer {
            adapter?.swapData(it)
        })
    }
}
