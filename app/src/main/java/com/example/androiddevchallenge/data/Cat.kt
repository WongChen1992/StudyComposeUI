package com.example.androiddevchallenge.data

import androidx.annotation.DrawableRes
import com.example.androiddevchallenge.R

data class Cat (val name: String,
                val location: String,
                val age: String,
                val content: String,
                @DrawableRes val catImgId: Int)