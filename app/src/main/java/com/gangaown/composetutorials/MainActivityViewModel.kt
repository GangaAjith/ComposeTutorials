package com.gangaown.composetutorials

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainActivityViewModel:ViewModel() {

    private val _stateval = mutableStateOf("Hello World!")
    val stateVal = _stateval

    fun onSearch(){

    }
}