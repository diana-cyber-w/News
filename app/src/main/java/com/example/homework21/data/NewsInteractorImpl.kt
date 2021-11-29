package com.example.homework21.data

import com.example.homework21.data.storage.NewsDao
import com.example.homework21.domain.News
import com.example.homework21.domain.NewsInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsInteractorImpl(private val newsDao: NewsDao) : NewsInteractor {

    override suspend fun getNews(): List<News> {
        return withContext(Dispatchers.IO) {
            newsDao.getAll().map { newsEntity -> newsEntity.toNews() }
        }
    }

    override suspend fun insertNews(vararg news: News) {
        withContext(Dispatchers.IO) {
            news
                .map { domainNews -> domainNews.toNewsEntity() }
                .forEach { newsEntity -> newsDao.insertNews(newsEntity) }
        }
    }

    override suspend fun deleteNews(vararg news: News) {
        withContext(Dispatchers.IO) {
            newsDao.deleteNews()
        }
    }
}