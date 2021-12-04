package com.example.homework21.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.homework21.R
import com.example.homework21.databinding.FilterFragmentLayoutBinding
import com.example.homework21.domain.News
import kotlinx.android.synthetic.main.filter_fragment_layout.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class FilterFragment : Fragment(R.layout.filter_fragment_layout) {

    private val binding: FilterFragmentLayoutBinding by viewBinding(FilterFragmentLayoutBinding::bind)

    private val filterViewModel: FilterSharedViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRadioGroup()
    }

    private fun initRadioGroup() {
        binding.radioGroup.setOnCheckedChangeListener { radioGroup, buttonId ->
            when (buttonId) {
                R.id.filterByDate -> filterViewModel.setDateFilter(News.Date.NOVEMBER)
                R.id.filterByAuthor -> filterViewModel.setAuthorFilter(News.Author.GLEB)
                R.id.filterByTopic -> filterViewModel.setTopicFilter(News.Topic.POLITICS)
            }

            filterNews.setOnClickListener {
                findNavController().navigate(R.id.toNewsFragment)
            }
        }
    }

}