package com.example.hw7.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "todo_item")
public class TodoItem {
    @PrimaryKey(autoGenerate = true)
    public long uid;

    @ColumnInfo(name = "item")
    public String item;

    public TodoItem(String item){
        this.item = item;
    }

}
