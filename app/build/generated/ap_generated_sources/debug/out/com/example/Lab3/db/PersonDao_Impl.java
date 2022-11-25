package com.example.Lab3.db;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PersonDao_Impl implements PersonDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Person> __insertionAdapterOfPerson;

  private final EntityInsertionAdapter<Cat> __insertionAdapterOfCat;

  private final EntityInsertionAdapter<Dog> __insertionAdapterOfDog;

  private final EntityDeletionOrUpdateAdapter<Person> __updateAdapterOfPerson;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  public PersonDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPerson = new EntityInsertionAdapter<Person>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `person` (`personUid`,`person`,`catUid`,`cat`,`catOwnerUid`,`dogUid`,`dog`,`dogOwnerUid`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Person value) {
        stmt.bindLong(1, value.uid);
        if (value.name == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.name);
        }
        final Cat _tmpCat = value.cat;
        if(_tmpCat != null) {
          stmt.bindLong(3, _tmpCat.uid);
          if (_tmpCat.name == null) {
            stmt.bindNull(4);
          } else {
            stmt.bindString(4, _tmpCat.name);
          }
          stmt.bindLong(5, _tmpCat.ownerUid);
        } else {
          stmt.bindNull(3);
          stmt.bindNull(4);
          stmt.bindNull(5);
        }
        final Dog _tmpDog = value.dog;
        if(_tmpDog != null) {
          stmt.bindLong(6, _tmpDog.uid);
          if (_tmpDog.name == null) {
            stmt.bindNull(7);
          } else {
            stmt.bindString(7, _tmpDog.name);
          }
          stmt.bindLong(8, _tmpDog.ownerUid);
        } else {
          stmt.bindNull(6);
          stmt.bindNull(7);
          stmt.bindNull(8);
        }
      }
    };
    this.__insertionAdapterOfCat = new EntityInsertionAdapter<Cat>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `cat_pet` (`catUid`,`cat`,`catOwnerUid`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Cat value) {
        stmt.bindLong(1, value.uid);
        if (value.name == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.name);
        }
        stmt.bindLong(3, value.ownerUid);
      }
    };
    this.__insertionAdapterOfDog = new EntityInsertionAdapter<Dog>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `dog_pet` (`dogUid`,`dog`,`dogOwnerUid`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Dog value) {
        stmt.bindLong(1, value.uid);
        if (value.name == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.name);
        }
        stmt.bindLong(3, value.ownerUid);
      }
    };
    this.__updateAdapterOfPerson = new EntityDeletionOrUpdateAdapter<Person>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `person` SET `personUid` = ?,`person` = ?,`catUid` = ?,`cat` = ?,`catOwnerUid` = ?,`dogUid` = ?,`dog` = ?,`dogOwnerUid` = ? WHERE `personUid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Person value) {
        stmt.bindLong(1, value.uid);
        if (value.name == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.name);
        }
        final Cat _tmpCat = value.cat;
        if(_tmpCat != null) {
          stmt.bindLong(3, _tmpCat.uid);
          if (_tmpCat.name == null) {
            stmt.bindNull(4);
          } else {
            stmt.bindString(4, _tmpCat.name);
          }
          stmt.bindLong(5, _tmpCat.ownerUid);
        } else {
          stmt.bindNull(3);
          stmt.bindNull(4);
          stmt.bindNull(5);
        }
        final Dog _tmpDog = value.dog;
        if(_tmpDog != null) {
          stmt.bindLong(6, _tmpDog.uid);
          if (_tmpDog.name == null) {
            stmt.bindNull(7);
          } else {
            stmt.bindString(7, _tmpDog.name);
          }
          stmt.bindLong(8, _tmpDog.ownerUid);
        } else {
          stmt.bindNull(6);
          stmt.bindNull(7);
          stmt.bindNull(8);
        }
        stmt.bindLong(9, value.uid);
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Person WHERE person.personUid = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Person person) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPerson.insert(person);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertCat(final Cat cat) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCat.insert(cat);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertDog(final Dog dog) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDog.insert(dog);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updatePerson(final Person person) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfPerson.handle(person);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final long uid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, uid);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDelete.release(_stmt);
    }
  }

  @Override
  public Person getPerson(final long uid) {
    final String _sql = "SELECT * FROM person WHERE person.personUid == ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, uid);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "personUid");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "person");
      final int _cursorIndexOfUid_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "catUid");
      final int _cursorIndexOfName_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "cat");
      final int _cursorIndexOfOwnerUid = CursorUtil.getColumnIndexOrThrow(_cursor, "catOwnerUid");
      final int _cursorIndexOfUid_2 = CursorUtil.getColumnIndexOrThrow(_cursor, "dogUid");
      final int _cursorIndexOfName_2 = CursorUtil.getColumnIndexOrThrow(_cursor, "dog");
      final int _cursorIndexOfOwnerUid_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "dogOwnerUid");
      final Person _result;
      if(_cursor.moveToFirst()) {
        final long _tmpUid;
        _tmpUid = _cursor.getLong(_cursorIndexOfUid);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final Cat _tmpCat;
        if (! (_cursor.isNull(_cursorIndexOfUid_1) && _cursor.isNull(_cursorIndexOfName_1) && _cursor.isNull(_cursorIndexOfOwnerUid))) {
          final long _tmpUid_1;
          _tmpUid_1 = _cursor.getLong(_cursorIndexOfUid_1);
          final String _tmpName_1;
          _tmpName_1 = _cursor.getString(_cursorIndexOfName_1);
          final long _tmpOwnerUid;
          _tmpOwnerUid = _cursor.getLong(_cursorIndexOfOwnerUid);
          _tmpCat = new Cat(_tmpUid_1,_tmpName_1,_tmpOwnerUid);
        }  else  {
          _tmpCat = null;
        }
        final Dog _tmpDog;
        if (! (_cursor.isNull(_cursorIndexOfUid_2) && _cursor.isNull(_cursorIndexOfName_2) && _cursor.isNull(_cursorIndexOfOwnerUid_1))) {
          final long _tmpUid_2;
          _tmpUid_2 = _cursor.getLong(_cursorIndexOfUid_2);
          final String _tmpName_2;
          _tmpName_2 = _cursor.getString(_cursorIndexOfName_2);
          final long _tmpOwnerUid_1;
          _tmpOwnerUid_1 = _cursor.getLong(_cursorIndexOfOwnerUid_1);
          _tmpDog = new Dog(_tmpUid_2,_tmpName_2,_tmpOwnerUid_1);
        }  else  {
          _tmpDog = null;
        }
        _result = new Person(_tmpName,_tmpUid);
        _result.cat = _tmpCat;
        _result.dog = _tmpDog;
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Person> getAll() {
    final String _sql = "SELECT * FROM person JOIN dog_pet ON personUid == dog_pet.dogOwnerUid JOIN cat_pet ON personUid == cat_pet.catOwnerUid";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "personUid");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "person");
      final int _cursorIndexOfUid_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "catUid");
      final int _cursorIndexOfName_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "cat");
      final int _cursorIndexOfOwnerUid = CursorUtil.getColumnIndexOrThrow(_cursor, "catOwnerUid");
      final int _cursorIndexOfUid_2 = CursorUtil.getColumnIndexOrThrow(_cursor, "dogUid");
      final int _cursorIndexOfName_2 = CursorUtil.getColumnIndexOrThrow(_cursor, "dog");
      final int _cursorIndexOfOwnerUid_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "dogOwnerUid");
      final int _cursorIndexOfUid_3 = CursorUtil.getColumnIndexOrThrow(_cursor, "dogUid");
      final int _cursorIndexOfName_3 = CursorUtil.getColumnIndexOrThrow(_cursor, "dog");
      final int _cursorIndexOfOwnerUid_2 = CursorUtil.getColumnIndexOrThrow(_cursor, "dogOwnerUid");
      final int _cursorIndexOfUid_4 = CursorUtil.getColumnIndexOrThrow(_cursor, "catUid");
      final int _cursorIndexOfName_4 = CursorUtil.getColumnIndexOrThrow(_cursor, "cat");
      final int _cursorIndexOfOwnerUid_3 = CursorUtil.getColumnIndexOrThrow(_cursor, "catOwnerUid");
      final List<Person> _result = new ArrayList<Person>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Person _item;
        final long _tmpUid;
        _tmpUid = _cursor.getLong(_cursorIndexOfUid);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final Cat _tmpCat;
        if (! (_cursor.isNull(_cursorIndexOfUid_1) && _cursor.isNull(_cursorIndexOfName_1) && _cursor.isNull(_cursorIndexOfOwnerUid) && _cursor.isNull(_cursorIndexOfUid_4) && _cursor.isNull(_cursorIndexOfName_4) && _cursor.isNull(_cursorIndexOfOwnerUid_3))) {
          final long _tmpUid_1;
          _tmpUid_1 = _cursor.getLong(_cursorIndexOfUid_1);
          final String _tmpName_1;
          _tmpName_1 = _cursor.getString(_cursorIndexOfName_1);
          final long _tmpOwnerUid;
          _tmpOwnerUid = _cursor.getLong(_cursorIndexOfOwnerUid);
          final long _tmpUid_2;
          _tmpUid_2 = _cursor.getLong(_cursorIndexOfUid_4);
          final String _tmpName_2;
          _tmpName_2 = _cursor.getString(_cursorIndexOfName_4);
          final long _tmpOwnerUid_1;
          _tmpOwnerUid_1 = _cursor.getLong(_cursorIndexOfOwnerUid_3);
          _tmpCat = new Cat(_tmpUid_1,_tmpName_1,_tmpOwnerUid);
        }  else  {
          _tmpCat = null;
        }
        final Dog _tmpDog;
        if (! (_cursor.isNull(_cursorIndexOfUid_2) && _cursor.isNull(_cursorIndexOfName_2) && _cursor.isNull(_cursorIndexOfOwnerUid_1) && _cursor.isNull(_cursorIndexOfUid_3) && _cursor.isNull(_cursorIndexOfName_3) && _cursor.isNull(_cursorIndexOfOwnerUid_2))) {
          final long _tmpUid_3;
          _tmpUid_3 = _cursor.getLong(_cursorIndexOfUid_2);
          final String _tmpName_3;
          _tmpName_3 = _cursor.getString(_cursorIndexOfName_2);
          final long _tmpOwnerUid_2;
          _tmpOwnerUid_2 = _cursor.getLong(_cursorIndexOfOwnerUid_1);
          final long _tmpUid_4;
          _tmpUid_4 = _cursor.getLong(_cursorIndexOfUid_3);
          final String _tmpName_4;
          _tmpName_4 = _cursor.getString(_cursorIndexOfName_3);
          final long _tmpOwnerUid_3;
          _tmpOwnerUid_3 = _cursor.getLong(_cursorIndexOfOwnerUid_2);
          _tmpDog = new Dog(_tmpUid_3,_tmpName_3,_tmpOwnerUid_2);
        }  else  {
          _tmpDog = null;
        }
        _item = new Person(_tmpName,_tmpUid);
        _item.cat = _tmpCat;
        _item.dog = _tmpDog;
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
