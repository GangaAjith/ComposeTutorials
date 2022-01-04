package com.gangaown.composetutorials

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private var _mutableHobbiesList = mutableListOf("Swimming","Reading","Cycling","Travelling","Photography")
    val hobbiesList = _mutableHobbiesList


    /*fun addHobbies(){
        val newList = mutableListOf("Swimming","Reading","Cycling","Travelling","Photography", "Cooking")
        _mutableHobbiesList.add("Cooking")

    }*/
}