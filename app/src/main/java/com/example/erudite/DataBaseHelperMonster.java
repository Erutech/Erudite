package com.example.erudite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHelperMonster extends SQLiteOpenHelper {
    // The Android's default system path
    // of your application database.
    private static String DB_PATH = "";
    private static String DB_NAME = "monster.db";
    private SQLiteDatabase myDataBase;
    private final Context myContext;
    private SQLiteOpenHelper sqLiteOpenHelper;
    //table name
    public static final String MONSTER_TABLE = "MONSTER_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_SPECIE_NAME = "SPECIE";
    public static final String COLUMN_NICKNAME = "NICKNAME";
    public static final String COLUMN_XP = "XP";
    public static final String COLUMN_LVL = "LVL";
    public static final String COLUMN_ERUID = "ERUID";

    public DataBaseHelperMonster(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
        this.myContext = context;
        DB_PATH = myContext.getDatabasePath(DB_NAME).toString();
    }

    // Creates an empty database
    // on the system and rewrites it
    // with your own database.
    public void createDataBase(SQLiteDatabase db) throws IOException {
        boolean dbExist = checkDataBase();
        if (dbExist) {
            // do nothing - database already exist
        }
        else {
            // By calling this method and
            // the empty database will be
            // created into the default system
            // path of your application
            // so we are gonna be able
            // to overwrite that database
            // with our database.
            this.getWritableDatabase();
            try {
                copyDataBase();
            }
            catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    // Check if the database already exist
    // to avoid re-copying the file each
    // time you open the application
    // return true if it exists
    // false if it doesn't.
    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_PATH;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        }
        catch (SQLiteException e) {
            // database doesn't exist yet.
            Log.e("message", "" + e);
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null;
    }

    /**
     * Copies your database from your
     * local assets-folder to the just
     * created empty database in the
     * system folder, from where it
     * can be accessed and handled.
     * This is done by transferring bytestream.
     * */
    private void copyDataBase() throws IOException {
        // Open your local db as the input stream
        InputStream myInput = myContext.getAssets().open(DB_NAME);
        // Path to the just created empty db
        String outFileName = DB_PATH;
        // Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);
        // transfer bytes from the
        // inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        // Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    public void openDataBase() throws SQLException {
        // Open the database
        String myPath = DB_PATH;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    }
    @Override
    public synchronized void close() {
        // close the database.
        if (myDataBase != null)
            myDataBase.close();
        super.close();
    }

    // this is called the first time a database is accessed. There should be code in here to create a new database.
    @Override
    public void onCreate(SQLiteDatabase myDataBase) {
        String createTableStatement = "CREATE TABLE " + MONSTER_TABLE + " " +
                "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_SPECIE_NAME + " TEXT, " + COLUMN_NICKNAME + " TEXT, " +
                COLUMN_XP + " INTEGER, " + COLUMN_LVL + " INTEGER, " + COLUMN_ERUID + " TEXT)";
        myDataBase.execSQL(createTableStatement);
    }

    // this is called if the database version number changes. It previous users apps from breaking when you change the database design.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + MONSTER_TABLE);
        onCreate(db);
    }

    void addMonster(MonsterModel monsterModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_SPECIE_NAME, monsterModel.getSpecie());
        cv.put(COLUMN_NICKNAME, monsterModel.getNickname());
        cv.put(COLUMN_XP, monsterModel.getXP());
        cv.put(COLUMN_LVL, monsterModel.getLvl());
        cv.put(COLUMN_ERUID, monsterModel.getEruID());
        db.insert(MONSTER_TABLE, null, cv);
        db.close();
    }

    // code to get all info in a list view
    public List<MonsterModel> getAllMonters() {
        List<MonsterModel> monsterList = new ArrayList<MonsterModel>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + MONSTER_TABLE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                MonsterModel monsterModel = new MonsterModel();
                monsterModel.setSpecie(cursor.getString(0));
                monsterModel.setNickname(cursor.getString(1));
                monsterModel.setXP(Integer.parseInt(cursor.getString(2)));
                monsterModel.setLvl(Integer.parseInt(cursor.getString(3)));
                monsterModel.setEruID(cursor.getString(4));
                // Adding contact to list
                monsterList.add(monsterModel);
            } while (cursor.moveToNext());
        }
        // return contact list
        return monsterList;
    }
}
