package com.example.viewbinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Counter_Viewmodel: ViewModel() {
var num= 0
    val count:MutableLiveData<Int> by lazy{

        MutableLiveData<Int>()
    }



}