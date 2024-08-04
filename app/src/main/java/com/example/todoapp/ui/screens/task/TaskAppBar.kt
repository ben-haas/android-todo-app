package com.example.todoapp.ui.screens.task

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.todoapp.ui.theme.topAppBarContainerColor
import com.example.todoapp.ui.theme.topAppBarContentColor
import com.example.todoapp.util.Action
import com.example.todoapp.R

@Composable
fun TaskAppBar(
    navigateToListScreen: (Action) -> Unit
) {
    NewTaskAppBar(navigateToListScreen = navigateToListScreen)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTaskAppBar(
    navigateToListScreen: (Action) -> Unit
) {
    TopAppBar(
        navigationIcon = {
            BackAction(onBackClicked = navigateToListScreen)
        },
        title = {
            Text(
                text = stringResource(id = R.string.new_task_title),
                color = MaterialTheme.colorScheme.topAppBarContentColor
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.topAppBarContainerColor
        ),
        actions = {
            AddAction(onAddClicked = navigateToListScreen)
        }
    )
}

@Composable
fun BackAction(
    onBackClicked: (Action) -> Unit
) {
    IconButton(onClick = {onBackClicked(Action.NO_ACTION)}) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack, 
            contentDescription = stringResource(id = R.string.back_arrow),
            tint = MaterialTheme.colorScheme.topAppBarContentColor
        )
    }
}

@Composable
fun AddAction(
    onAddClicked: (Action) -> Unit
) {
    IconButton(onClick = {onAddClicked(Action.ADD)}) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = stringResource(id = R.string.check),
            tint = MaterialTheme.colorScheme.topAppBarContentColor
        )
    }
}

@Composable
@Preview
fun NewTaskAppBarPreview() {
    NewTaskAppBar(
        navigateToListScreen = {}
    )
}