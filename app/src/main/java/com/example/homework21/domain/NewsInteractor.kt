package com.example.homework21.domain

interface NewsInteractor {
    suspend fun getNews(): List<News>

    suspend fun insertNews(vararg news: News)

    suspend fun deleteNews(vararg news: News)
}