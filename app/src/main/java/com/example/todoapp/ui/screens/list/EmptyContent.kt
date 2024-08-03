package com.example.todoapp.ui.screens.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.todoapp.R
import com.example.todoapp.ui.theme.EMPTY_SCREEN_ICON

@Composable
fun EmptyContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.size(EMPTY_SCREEN_ICON),
            painter = painterResource(id = R.drawable.frown_face),
            contentDescription = stringResource(id = R.string.sad_face_icon)
        )

        Text(
            text = stringResource(id = R.string.empty_screen_text),
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Composable
@Preview
fun EmptyContentPreview() {
    EmptyContent()
}