package com.example.hw7.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {TodoItem.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TodoItemDao mTodoItemDao();
}
