package com.example.myapplication3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

import com.example.myapplication3.ui.theme.MyApplication3Theme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.ui.layout.layoutId


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var selectedItem by remember { mutableIntStateOf(0) }
            val items = listOf("Songs", "Artists", "Playlists")
            val selectedIcons = listOf(Icons.Filled.Home, Icons.Filled.Favorite, Icons.Filled.Star)
            val unselectedIcons =
                listOf(Icons.Outlined.Home, Icons.Outlined.FavoriteBorder, Icons.Outlined.Home)

            MyApplication3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    NavigationBar {
                        items.forEachIndexed { index, item ->
                            NavigationBarItem(
                                icon = {
                                    Icon(
                                        if (selectedItem == index) selectedIcons[index] else unselectedIcons[index],
                                        contentDescription = item
                                    )
                                },
                                label = { Text(item) },
                                selected = selectedItem == index,
                                onClick = { selectedItem = index },

                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

