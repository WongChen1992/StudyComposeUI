package com.example.androiddevchallenge.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Cat
import androidx.compose.runtime.setValue

class MainViewModel : ViewModel() {
    val cats by mutableStateOf(
        listOf(
            Cat("Juno", "Rome", "1.2", "Very, very cute!", R.drawable.cat_1),
            Cat("Venus", "Paris", "3.6", "Very, very cute!", R.drawable.cat_2),
            Cat("Mars", "Toronto", "7.1", "Very, very cute!", R.drawable.cat_3),
            Cat("Saturn", "London", "1.11", "Very, very cute!", R.drawable.cat_4),
            Cat("Zeus", "Tokyo", "5.7", "Very, very cute!", R.drawable.cat_5),
            Cat("Diana", "Greece", "3.10", "Very, very cute!", R.drawable.cat_6),
            Cat("Apollo", "BeiJing", "6.4", "Very, very cute!", R.drawable.cat_7),
            Cat("Minerva", "Athens", "3.2", "Very, very cute!", R.drawable.cat_8)
        )
    )

    var currentCat: Cat? by mutableStateOf(null)

    fun cleanCat() {
        currentCat = null
    }
}