package com.example.erudite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String STUDENT_TABLE = "STUDENT_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_USER_NAME = "USER_NAME";
    public static final String COLUMN_USER_ID = "USER_ID";
    public static final String COLUMN_USER_COURSES = "USER_COURSES";
    public static final String COLUMN_ERU_ID = "ERU_ID";

    public DataBaseHelper(Context context) {
        super(context, "user.db", null, 1);
    }

    // this is called the first time a database is accessed. There should be code in here to create a new database.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + STUDENT_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_USER_NAME + " TEXT, " +  COLUMN_USER_ID + " TEXT, " + COLUMN_USER_COURSES + " TEXT, " + COLUMN_ERU_ID + " TEXT)";
        db.execSQL(createTableStatement);
    }

    // this is called if the database version number changes. It previous users apps from breaking when you change the database design.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    public boolean addOne(StudentModel studentModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_USER_NAME, studentModel.getName());
        cv.put(COLUMN_USER_ID, studentModel.getAbc123());
        cv.put(COLUMN_USER_COURSES, studentModel.getCourses());
        cv.put(COLUMN_ERU_ID, studentModel.getEruID());
        long insert = db.insert(STUDENT_TABLE, null, cv);
        if (insert == -1) {
            return false;
        }
        else {
            return true;
        }
    }
}
