package com.example.todoapp.ui.screens.list

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.todoapp.ui.theme.topAppBarContainerColor
import com.example.todoapp.ui.theme.topAppBarContentColor

@Composable
fun ListAppBar() {
    DefaultListAppBar()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultListAppBar() {
    TopAppBar(
        title = { Text(text = "Tasks", color = MaterialTheme.colorScheme.topAppBarContentColor) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.topAppBarContainerColor

        )
    )
}

@Composable
fun SearchListAppBar() {}

@Composable
@Preview
private fun DefaultListAppBarPreview() {
    DefaultListAppBar()
}