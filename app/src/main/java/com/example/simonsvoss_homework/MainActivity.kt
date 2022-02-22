package com.example.simonsvoss_homework

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simonsvoss_homework.models.Data
import com.example.simonsvoss_homework.models.Lock

class MainActivity : AppCompatActivity() {
    private val mainViewModel = MainViewModel()
    private lateinit var searchEditText: EditText
    private lateinit var recyclerview: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        binding.data = mainViewModel.data.value

        recyclerview = findViewById<RecyclerView>(R.id.mainRecyclerView)
        searchEditText = findViewById<EditText>(R.id.searchEditText)

        addEditTextTextChangeListener()

        val linearLayoutManager = LinearLayoutManager(
            this, RecyclerView.VERTICAL, false
        )
        recyclerview.layoutManager = linearLayoutManager

        mainViewModel.data.observe(this, Observer { data ->
            rerenderRecyclerViewWithCorrectData()
        })
    }

    private fun rerenderRecyclerViewWithCorrectData() {
        // few better checks will be needed to handle crashes / null pointers etc. It will take time and they are not the focus of this homework. So I am not doing those
        val data = mainViewModel.data.value

        if (data == null || !this::recyclerview.isInitialized) {
            return
        }

        if (searchEditText.text.length == 0) {
            recyclerview.adapter =
                MainRecyclerViewAdapter(getDataForAdapter(data.locks.toList(), data))
        } else {
            recyclerview.adapter =
                MainRecyclerViewAdapter(getFilteredDataAccordingToSearchText(data))
        }
    }

    private fun addEditTextTextChangeListener() {
        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                rerenderRecyclerViewWithCorrectData()
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {

            }

        })
    }

    private fun getDataForAdapter(locks: List<Lock>, data: Data): ArrayList<DataForAdapter> {
        val dataForAdapterArray = ArrayList<DataForAdapter>()

        locks.forEach { lock ->
            dataForAdapterArray.add(
                DataForAdapter(
                    lockName = lock.name,
                    buildingShortcutFloorRoomNumberString = getBuildingShortcutFloorRoomNumberString(
                        lock,
                        data
                    )
                )
            )
        }

        return dataForAdapterArray
    }

    private fun getBuildingShortcutFloorRoomNumberString(lock: Lock, data: Data): String {
        val buildingShortcut = data.buildings.first { lock.buildingId == it.id }.shortCut
        val floor = lock.floor
        val roomNumber = lock.roomNumber

        return "$buildingShortcut-$floor-$roomNumber"
    }

    private fun getFilteredDataAccordingToSearchText(data: Data): ArrayList<DataForAdapter> {
        // for highlighting found text, HTML or Spannable text is needed. It requires some time. I am not doing that right now.
        val filteredLocksForAdapter = data.locks.filter { lock ->
            lock.name.contains(searchEditText.text, true) ||
                    lock.floor?.contains(searchEditText.text, true) ?: false ||
                    lock.roomNumber.contains(searchEditText.text, true) ||
                    checkBuildingSearchConditions(lock, data)
        }

        return getDataForAdapter(filteredLocksForAdapter, data)
    }

    private fun checkBuildingSearchConditions(lock: Lock, data: Data): Boolean {
        val building = data.buildings.first { lock.buildingId == it.id }

        if (building.shortCut.contains(searchEditText.text, true)
            || building.shortCut.contains(searchEditText.text, true)
        ) {
            return true
        }

        return false
    }
}