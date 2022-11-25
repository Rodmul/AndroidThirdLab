package com.example.Lab3.db;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface PersonDao {

    @Query("SELECT * FROM person WHERE person.personUid == :uid")
    Person getPerson(long uid);

    @Query("SELECT * FROM person JOIN dog_pet ON personUid == dog_pet.dogOwnerUid JOIN cat_pet ON personUid == cat_pet.catOwnerUid")
    List<Person> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Person person);

    @Query("DELETE FROM Person WHERE person.personUid = :uid")
    void delete(long uid);

    @Insert
    void insertCat(Cat cat);

    @Insert
    void insertDog(Dog dog);

    @Update
    void updatePerson(Person person);
}
