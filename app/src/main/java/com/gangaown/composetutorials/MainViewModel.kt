package com.gangaown.composetutorials

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var hobbies = mutableStateListOf("Swimming","Reading","Cycling","Photography")

    fun addHobbies(){
        hobbies.add("Travelling")
    }
}