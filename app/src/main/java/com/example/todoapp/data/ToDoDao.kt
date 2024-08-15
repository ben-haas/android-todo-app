package com.example.todoapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.todoapp.data.models.ToDoTask
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {

    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAllTasks(): Flow<List<ToDoTask>>

    @Query("SELECT * FROM todo_table WHERE id = :taskId")
    fun getSelectedTask(taskId: Int): Flow<ToDoTask>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(toDoTask: ToDoTask)

    @Update
    suspend fun updateTask(toDoTask: ToDoTask)

    @Delete
    suspend fun deleteTask(toDoTask: ToDoTask)

    @Query("DELETE FROM todo_table")
    suspend fun deleteAllTasks()

    @Query(
        """
            SELECT * FROM todo_table 
            WHERE taskTitle LIKE :searchQuery 
            OR taskDescription LIKE :searchQuery
        """
    )
    fun searchDatabase(searchQuery: String): Flow<List<ToDoTask>>

    @Query(
        """
        SELECT * FROM todo_table ORDER BY CASE 
            WHEN taskPriority LIKE 'L%' THEN 1 
            WHEN taskPriority LIKE 'H%' THEN 3 
            ELSE 2 END
    """
    )
    fun sortByLowPriority(): Flow<List<ToDoTask>>

    @Query(
        """
        SELECT * FROM todo_table ORDER BY CASE 
            WHEN taskPriority LIKE 'H%' THEN 1 
            WHEN taskPriority LIKE 'L%' THEN 3 
            ELSE 2 END
    """
    )
    fun sortByHighPriority(): Flow<List<ToDoTask>>
}