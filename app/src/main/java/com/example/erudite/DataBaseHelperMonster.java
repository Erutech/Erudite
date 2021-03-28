package com.example.erudite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.erudite.ui.login.MonsterModel;

public class DataBaseHelperMonster extends SQLiteOpenHelper {
    public static final String MONSTER_TABLE = "MONSTER_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_SPECIE_NAME = "SPECIE";
    public static final String COLUMN_NICKNAME = "NICKNAME";
    public static final String COLUMN_XP = "XP";
    public static final String COLUMN_LVL = "LVL";
    public static final String COLUMN_ERUID = "ERUID";

    public DataBaseHelperMonster(@Nullable Context context) {
        super(context, "monster.db", null, 1);
    }

    // this is called the first time a database is accessed. There should be code in here to create a new database.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + MONSTER_TABLE + " " +
                "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_SPECIE_NAME + " TEXT, " + COLUMN_NICKNAME + " TEXT, " +
                COLUMN_XP + " INTEGER, " + COLUMN_LVL + " INTEGER, " + COLUMN_ERUID + " TEXT)";
        db.execSQL(createTableStatement);
    }

    // this is called if the database version number changes. It previous users apps from breaking when you change the database design.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    public boolean addOne(MonsterModel monsterModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_SPECIE_NAME, monsterModel.getSpecie());
        cv.put(COLUMN_NICKNAME, monsterModel.getNickname());
        cv.put(COLUMN_XP, monsterModel.getXP());
        cv.put(COLUMN_LVL, monsterModel.getLvl());
        cv.put(COLUMN_LVL, monsterModel.getEruID());
        long insert = db.insert(MONSTER_TABLE, null, cv);
        if (insert == -1) {
            return false;
        }
        else {
            return true;
        }
    }
}
