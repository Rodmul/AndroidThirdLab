package com.example.hw7.db;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface TodoItemDao {

    @Query("SELECT * FROM todo_item")
    List<TodoItem> getAll();

    @Insert
    void insert(TodoItem todoItem);

    @Query("DELETE FROM todo_item WHERE item = :item")
    void delete(String item);
}
