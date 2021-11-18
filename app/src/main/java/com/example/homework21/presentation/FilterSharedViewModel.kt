package com.example.homework21.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework21.data.NewsData
import com.example.homework21.domain.NewsInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FilterSharedViewModel(private val interactor: NewsInteractor) : ViewModel() {

    val filterLiveData: LiveData<List<NewsData>> get() = _filterLiveData
    private val _filterLiveData = MutableLiveData(interactor.loadText())

    private val scope = CoroutineScope(Dispatchers.Main)


    fun setDateFilter(filter: String) {
        scope.launch {
            _filterLiveData.value = interactor.loadText().filter { newsData ->
                newsData.date == filter
            }
        }
    }

    fun setTopicFilter(filter: String) {
        scope.launch {
            _filterLiveData.value = interactor.loadText().filter { newsData ->
                newsData.topic == filter
            }
        }
    }

    fun setAuthorFilter(filter: String) {
        scope.launch {
            _filterLiveData.value = interactor.loadText().filter { newsData ->
                newsData.author == filter
            }
        }
    }
}