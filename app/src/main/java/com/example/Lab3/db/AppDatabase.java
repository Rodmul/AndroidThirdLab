package com.example.Lab3.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Person.class, Cat.class, Dog.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PersonDao personDao();
}
