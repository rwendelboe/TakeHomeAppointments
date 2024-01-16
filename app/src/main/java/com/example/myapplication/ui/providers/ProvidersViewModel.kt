package com.example.myapplication.ui.providers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProvidersViewModel : ViewModel() {

    // Normally in a real production app this is where we would make the api calls and update our fields using the liveData

    private val _text = MutableLiveData<String>().apply {
        value = "Select desired date and time you would like to work."
    }
    val text: LiveData<String> = _text
}