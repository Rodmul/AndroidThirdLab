package com.example.Lab3.db;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "person")
public class Person {
    public Person(String name, long uid) {
        this.name = name;
        this.uid = uid;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "personUid")
    public long uid;

    @ColumnInfo(name = "person")
    public String name;

    @Embedded
    public Cat cat;
    @Embedded
    public Dog dog;

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
