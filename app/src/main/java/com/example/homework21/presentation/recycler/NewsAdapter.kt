package com.example.homework21.presentation.recycler

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework21.data.NewsData

class NewsAdapter : RecyclerView.Adapter<NewsViewHolder>() {

    private var items: List<NewsData> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(data: List<NewsData>) {
        items = data
        notifyDataSetChanged()
    }

//    fun filterByAuthor() {
//        var filteredByAuthorList: List<NewsData> = mutableListOf()
//        for (item in items) {
//            if(item.author == "Иван Иванов") {
//                filteredByAuthorList.
//            }
//        }
//    }
}