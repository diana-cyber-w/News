package com.example.homework21.domain

import com.example.homework21.data.NewsData

interface NewsInteractor {
    fun loadText(): List<NewsData>
}