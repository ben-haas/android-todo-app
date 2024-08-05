package com.example.todoapp.ui.screens.task

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.todoapp.data.models.ToDoTask
import com.example.todoapp.util.Action

@Composable
fun TaskScreen(
    navigateToListScreen: (Action) -> Unit,
    selectedTask: ToDoTask?
) {
    Scaffold(
        topBar = {
            TaskAppBar(
                selectedTask = selectedTask,
                navigateToListScreen = navigateToListScreen
            )
        },
        content = {}
    )
}