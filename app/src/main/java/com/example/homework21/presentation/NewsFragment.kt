package com.example.homework21.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homework21.R
import com.example.homework21.presentation.recycler.NewsAdapter
import kotlinx.android.synthetic.main.news_fragment_layout.*
import org.koin.android.viewmodel.ext.android.sharedViewModel


class NewsFragment : Fragment() {

    companion object {
        fun newInstance() = NewsFragment()
        const val TAG = "news"
    }

    private val adapter by lazy { NewsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(
        R.layout.news_fragment_layout, container, false
    )

    private val filterSharedViewModel: FilterSharedViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserves()
        initRecycler()
        loader.setOnClickListener {
            filterSharedViewModel.loadNews()
        }
        inserting.setOnClickListener {
            filterSharedViewModel.insertNews()
        }
        filter.setOnClickListener {
            val filterFragment = FilterFragment.newInstance()
            replaceFragment(FilterFragment.TAG, filterFragment)
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

    private fun replaceFragment(tag: String, newInstance: FilterFragment) {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.addToBackStack(tag)
            ?.replace(R.id.container, newInstance)
            ?.commit()
    }
}