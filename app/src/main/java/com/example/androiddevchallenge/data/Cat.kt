package com.example.androiddevchallenge.data

import androidx.annotation.DrawableRes

data class Cat(
    val name: String,
    val location: String,
    val age: String,
    val content: String,
    @DrawableRes val catImgId: Int
)