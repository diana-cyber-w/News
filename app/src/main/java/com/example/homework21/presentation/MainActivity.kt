package com.example.homework21.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework21.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        val newsFragment = NewsFragment.newInstance()
        openFragment(NewsFragment.TAG, newsFragment)
    }

    private fun openFragment(tag: String, newInstance: NewsFragment) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(tag)
            .add(R.id.container, newInstance)
            .commit()
    }
}