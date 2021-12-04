package com.example.homework21.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.homework21.R
import com.example.homework21.databinding.NewsFragmentLayoutBinding
import com.example.homework21.presentation.recycler.NewsAdapter
import kotlinx.android.synthetic.main.news_fragment_layout.*
import org.koin.android.viewmodel.ext.android.sharedViewModel


class NewsFragment : Fragment(R.layout.news_fragment_layout) {

    private val binding: NewsFragmentLayoutBinding by viewBinding(NewsFragmentLayoutBinding::bind)

    private val adapter by lazy { NewsAdapter() }
    private val filterSharedViewModel: FilterSharedViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserves()
        initRecycler()
        binding.loader.setOnClickListener {
            filterSharedViewModel.loadNews()
        }
        binding.inserting.setOnClickListener {
            filterSharedViewModel.insertNews()
        }
        binding.filter.setOnClickListener {
            findNavController().navigate(R.id.toFilter)
        }
    }

    private fun initRecycler() {
        recycler.adapter = adapter
    }

    private fun initObserves() {
        filterSharedViewModel.filterLiveData.observe(viewLifecycleOwner) { filterText ->
            adapter.submitList(filterText)
        }
    }

}