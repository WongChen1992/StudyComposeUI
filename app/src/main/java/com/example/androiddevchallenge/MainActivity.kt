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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Cat
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.viewmodel.MainViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material.TopAppBar
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                Box {
                    Column {
                        TopAppBar(
                            title = {
                                Text("Cat Cat")
                            }
                        )
                        CatList()
                    }

                    val currentCat = viewModel.currentCat
                    if (currentCat != null) {
                        CatDetails(currentCat)
                    }
                }

            }
        }
    }

    override fun onBackPressed() {
        if (viewModel.currentCat != null) {
            viewModel.cleanCat()
        } else {
            super.onBackPressed()
        }
    }
}

@Composable
fun CatList() {
    val viewModel: MainViewModel = viewModel()
    val catList: List<Cat> = viewModel.cats
    LazyColumn {
        items(catList) { data ->
            CatItem(data)
        }
    }
}

@Composable
fun CatItem(data: Cat) {
    val viewModel: MainViewModel = viewModel()
    Row(
        Modifier
            .padding(16.dp, 16.dp, 16.dp, 0.dp)
            .fillMaxWidth()
            .clickable {
                viewModel.currentCat = data
            }) {
        Image(
            painter = painterResource(data.catImgId),
            contentDescription = data.name,
            Modifier.size(100.dp)
        )
        Column(Modifier.padding(12.dp)) {
            Text(text = data.name, style = MaterialTheme.typography.h6)
            Text(text = "location: " + data.location)
            Text(text = "age: " + data.age + " year-old")
        }
    }
}

@Composable
fun CatDetails(data: Cat) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painterResource(data.catImgId),
            data.name,
            Modifier.aspectRatio(1f),
            contentScale = ContentScale.Crop
        )
        Text(
            text = data.name, Modifier
                .padding(10.dp), style = MaterialTheme.typography.h4
        )
        Text(
            text = "location: " + data.location, Modifier
                .padding(5.dp)
        )
        Text(
            text = "age: " + data.age + " year-old", Modifier
                .padding(5.dp)
        )
        Text(
            text = data.content, Modifier
                .padding(5.dp), style = MaterialTheme.typography.h6
        )
        Button(
            onClick = { }, Modifier
                .padding(16.dp)
                .align(Alignment.End)
        )
        {
            Text(text = "Adopt")
        }
    }
}

@Preview
@Composable
fun DogDetailsPreview() {
    CatDetails(
        Cat("Juno", "Rome", "1.2", "Very, very cute!", R.drawable.cat_1)
    )
}
