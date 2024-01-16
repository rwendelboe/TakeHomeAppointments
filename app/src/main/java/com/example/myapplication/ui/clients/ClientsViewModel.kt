package com.example.myapplication.ui.clients

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ClientsViewModel : ViewModel() {

    // Normally in a real production app this is where we would make the api calls and update our fields using the liveData

    private val _text = MutableLiveData<String>().apply {
        value = "Your provider\'s available times"
    }
    val text: LiveData<String> = _text
}