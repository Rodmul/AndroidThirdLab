package com.example.Lab3.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cat_pet")
public class Cat {

    public Cat(long uid, String name, long ownerUid) {
        this.uid = uid;
        this.name = name;
        this.ownerUid = ownerUid;
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "catUid")
    public long uid;

    @ColumnInfo(name = "cat")
    public String name;

    @ColumnInfo(name = "catOwnerUid")
    public long ownerUid;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}