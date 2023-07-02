package com.summerpractice.project.ui.developerMode

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DeveloperModeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Developer Mode Activated"
    }
    val text: LiveData<String> = _text
}