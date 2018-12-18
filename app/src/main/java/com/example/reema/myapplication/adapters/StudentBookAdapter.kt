package com.example.reema.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.reema.myapplication.R
import com.example.reema.myapplication.data.model.StudentBookModel
import kotlinx.android.synthetic.main.item_student_books.view.*
import java.util.*

class StudentBookAdapter : RecyclerView.Adapter<StudentBookAdapter.StudentBookViewHolder>() {
    private var data: List<StudentBookModel> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentBookViewHolder {
        return StudentBookViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_student_books, parent, false)
        )
    }

    override fun getItemCount() = data.size
    override fun onBindViewHolder(holder: StudentBookViewHolder, position: Int) = holder.bind(data[position])
    fun swapData(data: List<StudentBookModel>) {
        this.data = data
        notifyDataSetChanged()
    }

    class StudentBookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: StudentBookModel) {
            itemView.text_student_name.text = item.studentName
            itemView.text_book_name.text = item.bookName
            itemView.text_issue_name.text = item.issueDate
        }
    }
}