package com.example.simonsvoss_homework

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simonsvoss_homework.models.Data
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.json.JSONObject
import java.net.URL

class MainViewModel : ViewModel() {
      val data = MutableLiveData<Data>()

    init {
        loadData()
    }

    private fun loadData() {
        // Do an asynchronous operation to fetch users.
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                fetchAsync("https://simonsvoss-homework.herokuapp.com/sv_lsm_data.json")
            }
        }
    }

    private suspend fun fetchAsync(url: String) {
        data.postValue(Json.decodeFromString(URL(url).readText()))
    }
}