package com.example.homework21.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework21.domain.News
import com.example.homework21.domain.NewsInteractor
import kotlinx.coroutines.launch

class FilterSharedViewModel(private val interactor: NewsInteractor) : ViewModel() {

    val filterLiveData: LiveData<List<News>> get() = _filterLiveData
    private val _filterLiveData = MutableLiveData<List<News>>()

    fun loadNews() {
        viewModelScope.launch {
            _filterLiveData.value = interactor.getNews()
        }
    }

    fun deleteNews() {
        viewModelScope.launch {
            interactor.deleteNews()
        }
    }

    fun setDateFilter(filter: News.Date) {
        viewModelScope.launch {
            _filterLiveData.value = interactor.getNews().filter { newsData ->
                newsData.date == filter
            }
        }
    }

    fun setTopicFilter(filter: News.Topic) {
        viewModelScope.launch {
            _filterLiveData.value = interactor.getNews().filter { newsData ->
                newsData.topic == filter
            }
        }
    }

    fun setAuthorFilter(filter: News.Author) {
        viewModelScope.launch {
            _filterLiveData.value = interactor.getNews().filter { newsData ->
                newsData.author == filter
            }
        }
    }

    fun insertNews() {
        viewModelScope.launch {
            interactor.insertNews(
                News(
                    title = News.Title.SPORT,
                    author = News.Author.PETER,
                    topic = News.Topic.SPORT,
                    text = News.Text.SPORT,
                    date = News.Date.OCTOBER
                ),
                News(
                    title = News.Title.TECHNOLOGIES,
                    author = News.Author.NIKOLAY,
                    topic = News.Topic.TECHNOLOGIES,
                    text = News.Text.TECHNOLOGIES,
                    date = News.Date.OCTOBER
                ),
                News(
                    title = News.Title.ECONOMY,
                    author = News.Author.PETER,
                    topic = News.Topic.ECONOMY,
                    text = News.Text.ECONOMY,
                    date = News.Date.NOVEMBER
                ),
                News(
                    title = News.Title.POLITICS,
                    author = News.Author.GLEB,
                    topic = News.Topic.POLITICS,
                    text = News.Text.POLITICS,
                    date = News.Date.AUGUST
                ),
                News(
                    title = News.Title.SPORT,
                    author = News.Author.IVAN,
                    topic = News.Topic.SPORT,
                    text = News.Text.SPORT,
                    date = News.Date.SEPTEMBER
                ),
                News(
                    title = News.Title.SPORT,
                    author = News.Author.IVAN,
                    topic = News.Topic.SPORT,
                    text = News.Text.SPORT,
                    date = News.Date.NOVEMBER
                ),

                News(
                    title = News.Title.ECONOMY,
                    author = News.Author.PETER,
                    topic = News.Topic.ECONOMY,
                    text = News.Text.ECONOMY,
                    date = News.Date.OCTOBER
                ),
                News(
                    title = News.Title.TECHNOLOGIES,
                    author = News.Author.GLEB,
                    topic = News.Topic.TECHNOLOGIES,
                    text = News.Text.TECHNOLOGIES,
                    date = News.Date.NOVEMBER
                ),
                News(
                    title = News.Title.POLITICS,
                    author = News.Author.PETER,
                    topic = News.Topic.POLITICS,
                    text = News.Text.POLITICS,
                    date = News.Date.NOVEMBER
                ),
                News(
                    title = News.Title.TECHNOLOGIES,
                    author = News.Author.NIKOLAY,
                    topic = News.Topic.TECHNOLOGIES,
                    text = News.Text.TECHNOLOGIES,
                    date = News.Date.AUGUST
                ),
                News(
                    title = News.Title.SPORT,
                    author = News.Author.IVAN,
                    topic = News.Topic.SPORT,
                    text = News.Text.SPORT,
                    date = News.Date.OCTOBER
                ),
                News(
                    title = News.Title.TECHNOLOGIES,
                    author = News.Author.NIKOLAY,
                    topic = News.Topic.TECHNOLOGIES,
                    text = News.Text.TECHNOLOGIES,
                    date = News.Date.SEPTEMBER
                ),
                News(
                    title = News.Title.POLITICS,
                    author = News.Author.NIKOLAY,
                    topic = News.Topic.POLITICS,
                    text = News.Text.POLITICS,
                    date = News.Date.NOVEMBER
                ),
                News(
                    title = News.Title.SPORT,
                    author = News.Author.GLEB,
                    topic = News.Topic.SPORT,
                    text = News.Text.SPORT,
                    date = News.Date.SEPTEMBER
                ),
                News(
                    title = News.Title.ECONOMY,
                    author = News.Author.PETER,
                    topic = News.Topic.ECONOMY,
                    text = News.Text.ECONOMY,
                    date = News.Date.OCTOBER
                ),
                News(
                    title = News.Title.TECHNOLOGIES,
                    author = News.Author.GLEB,
                    topic = News.Topic.TECHNOLOGIES,
                    text = News.Text.TECHNOLOGIES,
                    date = News.Date.AUGUST
                )
            )
        }
    }
}
