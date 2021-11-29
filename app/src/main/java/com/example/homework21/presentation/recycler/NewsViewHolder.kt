package com.example.homework21.presentation.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homework21.R
import com.example.homework21.domain.News
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

    fun bindView(item: News) {
        titleTextView.text = item.title.title
        authorTextView.text = item.author.author
        dateTextView.text = item.date.date
        topicTextView.text = item.topic.topic
        textTextView.text = item.text.text
    }
}