package com.example.simonsvoss_homework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val mainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_main)
//        binding.data = mainViewModel.data.value

        val recyclerview = findViewById<RecyclerView>(R.id.mainRecyclerView)
        val linearLayoutManager = LinearLayoutManager(
            this, RecyclerView.VERTICAL,false)
        recyclerview.layoutManager = linearLayoutManager

        mainViewModel.data.observe(this, Observer { data ->
            recyclerview.adapter = MainRecyclerViewAdapter( data)
        })
    }
}