package com.example.viewmodel_2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel()  {
    var num= 0
    val count: MutableLiveData<Int> by lazy{

        MutableLiveData<Int>()
    }



}