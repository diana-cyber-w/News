package com.example.homework21.presentation.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homework21.R
import com.example.homework21.data.NewsData
import kotlinx.android.synthetic.main.news_layout.view.*

class NewsViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
        fun from(parent: ViewGroup): NewsViewHolder {
            return NewsViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.news_layout, parent, false)
            )
        }
    }

    private val titleTextView: TextView by lazy { itemView.title }
    private val authorTextView: TextView by lazy { itemView.author }
    private val dateTextView: TextView by lazy { itemView.date }
    private val topicTextView: TextView by lazy { itemView.topic }
    private val textTextView: TextView by lazy { itemView.text }

    fun bindView(item: NewsData) {
        titleTextView.text = item.title
        authorTextView.text = item.author
        dateTextView.text = item.date
        topicTextView.text = item.topic
        textTextView.text = item.text
    }
}