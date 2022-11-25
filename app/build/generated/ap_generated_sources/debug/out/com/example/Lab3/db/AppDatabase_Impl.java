package com.example.Lab3.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile PersonDao _personDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `person` (`personUid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `person` TEXT, `catUid` INTEGER, `cat` TEXT, `catOwnerUid` INTEGER, `dogUid` INTEGER, `dog` TEXT, `dogOwnerUid` INTEGER)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `cat_pet` (`catUid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `cat` TEXT, `catOwnerUid` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `dog_pet` (`dogUid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `dog` TEXT, `dogOwnerUid` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '7b7d362bff9c8c2059c64ef53f17cc41')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `person`");
        _db.execSQL("DROP TABLE IF EXISTS `cat_pet`");
        _db.execSQL("DROP TABLE IF EXISTS `dog_pet`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsPerson = new HashMap<String, TableInfo.Column>(8);
        _columnsPerson.put("personUid", new TableInfo.Column("personUid", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPerson.put("person", new TableInfo.Column("person", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPerson.put("catUid", new TableInfo.Column("catUid", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPerson.put("cat", new TableInfo.Column("cat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPerson.put("catOwnerUid", new TableInfo.Column("catOwnerUid", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPerson.put("dogUid", new TableInfo.Column("dogUid", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPerson.put("dog", new TableInfo.Column("dog", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPerson.put("dogOwnerUid", new TableInfo.Column("dogOwnerUid", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPerson = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPerson = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPerson = new TableInfo("person", _columnsPerson, _foreignKeysPerson, _indicesPerson);
        final TableInfo _existingPerson = TableInfo.read(_db, "person");
        if (! _infoPerson.equals(_existingPerson)) {
          return new RoomOpenHelper.ValidationResult(false, "person(com.example.Lab3.db.Person).\n"
                  + " Expected:\n" + _infoPerson + "\n"
                  + " Found:\n" + _existingPerson);
        }
        final HashMap<String, TableInfo.Column> _columnsCatPet = new HashMap<String, TableInfo.Column>(3);
        _columnsCatPet.put("catUid", new TableInfo.Column("catUid", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCatPet.put("cat", new TableInfo.Column("cat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCatPet.put("catOwnerUid", new TableInfo.Column("catOwnerUid", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCatPet = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCatPet = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCatPet = new TableInfo("cat_pet", _columnsCatPet, _foreignKeysCatPet, _indicesCatPet);
        final TableInfo _existingCatPet = TableInfo.read(_db, "cat_pet");
        if (! _infoCatPet.equals(_existingCatPet)) {
          return new RoomOpenHelper.ValidationResult(false, "cat_pet(com.example.Lab3.db.Cat).\n"
                  + " Expected:\n" + _infoCatPet + "\n"
                  + " Found:\n" + _existingCatPet);
        }
        final HashMap<String, TableInfo.Column> _columnsDogPet = new HashMap<String, TableInfo.Column>(3);
        _columnsDogPet.put("dogUid", new TableInfo.Column("dogUid", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDogPet.put("dog", new TableInfo.Column("dog", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDogPet.put("dogOwnerUid", new TableInfo.Column("dogOwnerUid", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDogPet = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDogPet = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDogPet = new TableInfo("dog_pet", _columnsDogPet, _foreignKeysDogPet, _indicesDogPet);
        final TableInfo _existingDogPet = TableInfo.read(_db, "dog_pet");
        if (! _infoDogPet.equals(_existingDogPet)) {
          return new RoomOpenHelper.ValidationResult(false, "dog_pet(com.example.Lab3.db.Dog).\n"
                  + " Expected:\n" + _infoDogPet + "\n"
                  + " Found:\n" + _existingDogPet);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "7b7d362bff9c8c2059c64ef53f17cc41", "1319cb573a695e4e67f4250c674e734b");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "person","cat_pet","dog_pet");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `person`");
      _db.execSQL("DELETE FROM `cat_pet`");
      _db.execSQL("DELETE FROM `dog_pet`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public PersonDao personDao() {
    if (_personDao != null) {
      return _personDao;
    } else {
      synchronized(this) {
        if(_personDao == null) {
          _personDao = new PersonDao_Impl(this);
        }
        return _personDao;
      }
    }
  }
}
