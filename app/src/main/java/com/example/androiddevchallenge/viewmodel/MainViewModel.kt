/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Cat

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
