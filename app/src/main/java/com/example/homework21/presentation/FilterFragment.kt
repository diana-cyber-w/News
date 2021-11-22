package com.example.homework21.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homework21.R
import com.example.homework21.data.NewsAuthor
import com.example.homework21.data.NewsDate
import com.example.homework21.data.NewsTopic
import kotlinx.android.synthetic.main.filter_fragment_layout.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class FilterFragment : Fragment() {

    companion object {
        fun newInstance() = FilterFragment()
        const val TAG = "filter"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(
        R.layout.filter_fragment_layout, container, false
    )

    private val filterViewModel: FilterSharedViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRadioGroup()
    }

    private val dateFilter: NewsDate = NewsDate.NOVEMBER
    private val authorFilter: NewsAuthor = NewsAuthor.GLEB
    private val topicFilter: NewsTopic = NewsTopic.POLITICS

    private fun initRadioGroup() {
        radioGroup.setOnCheckedChangeListener { radioGroup, buttonId ->
            when (buttonId) {
                R.id.filterByDate -> filterViewModel.setDateFilter(dateFilter.date)
                R.id.filterByAuthor -> filterViewModel.setAuthorFilter(authorFilter.author)
                R.id.filterByTopic -> filterViewModel.setTopicFilter(topicFilter.topic)
            }

            filterNews.setOnClickListener {
                val newsFragment = NewsFragment.newInstance()
                replaceFragment(NewsFragment.TAG, newsFragment)
            }
        }
    }

    private fun replaceFragment(tag: String, newInstance: NewsFragment) {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.addToBackStack(tag)
            ?.replace(R.id.container, newInstance)
            ?.commit()
    }
}