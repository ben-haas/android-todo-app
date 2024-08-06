package com.example.todoapp.ui.screens.task

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.todoapp.data.models.Priority
import com.example.todoapp.data.models.ToDoTask
import com.example.todoapp.ui.screens.list.ListContent
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
        content = { paddingValues ->
            Box(modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()) {
                TaskContent(
                    title = "",
                    onTitleChange = {},
                    description = "",
                    onDescriptionChange = {},
                    priority = Priority.LOW,
                    onPrioritySelected = {}
                )
            }

        }
    )
}