package com.example.homework21.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.homework21.R
import com.example.homework21.databinding.HeaderViewFragmentLayoutBinding

class HeaderViewFragment : Fragment(R.layout.header_view_fragment_layout) {

    private val binding: HeaderViewFragmentLayoutBinding by viewBinding(
        HeaderViewFragmentLayoutBinding::bind
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toHomework.setOnClickListener {
            findNavController().navigate(R.id.toNewsFragment)
        }
    }
}