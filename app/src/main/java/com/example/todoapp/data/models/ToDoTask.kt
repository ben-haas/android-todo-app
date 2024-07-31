package com.example.todoapp.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.todoapp.util.Constants.DATABASE_TABLE

@Entity(tableName = DATABASE_TABLE)
data class ToDoTask(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "taskTitle") val title: String,
    @ColumnInfo(name = "taskDescription") val description: String,
    @ColumnInfo(name = "taskPriority") val priority: Priority
)