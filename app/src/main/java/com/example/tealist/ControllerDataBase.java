package com.example.tealist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ControllerDataBase {
    private static final String BASENAME = "database.db";
    private static final int DATA_BASE_VERSION = 1;

    private static final String TABLE_NAME = "TABLETEA";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DISC = "discription";
    private static final String COLUMN_PIC = "picture";

    private static final int NUM_COLUMN_ID = 0;
    private static final int NUM_COLUMN_NAME = 1;
    private static final int NUM_COLUMN_DISC = 2;
    private static final int NUM_COLUMN_PIC = 3;

    private SQLiteDatabase db;

    public ControllerDataBase(Context context){
        OpenHelper openHelper = new OpenHelper(context);
        db = openHelper.getWritableDatabase();
    }

    protected int update(Tea tea){ // обновляем поля бд
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, tea.getName());
        contentValues.put(COLUMN_DISC, tea.getDescription());
        contentValues.put(COLUMN_PIC, tea.getImageURL());
        return db.update(TABLE_NAME, contentValues, COLUMN_ID + " = ?", new String[] {String.valueOf(tea.getId())});
    }

    public Tea select(int id){ //выводим поля бд
        String query = "SELECT * FROM "+ TABLE_NAME + " WHERE "+ COLUMN_ID+" = "+ id;
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToNext();
        return new Tea(cursor.getInt(NUM_COLUMN_ID), cursor.getString(NUM_COLUMN_NAME),
                cursor.getString(NUM_COLUMN_DISC), cursor.getString(NUM_COLUMN_PIC));
    }

    protected void delete(long id) { // удаляем поля
        db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[] { String.valueOf(id) });
    }

    public long insert(Tea tea) { // добавляем поля
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, tea.getName());
        contentValues.put(COLUMN_DISC, tea.getDescription());
        contentValues.put(COLUMN_PIC, tea.getImageURL());
        return db.insert(TABLE_NAME, null, contentValues);
    }

    public List<Tea> select(){
        List<Tea> listTea = new ArrayList<Tea>();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        while (res.moveToNext()){
            Tea tea = new Tea(res.getInt(NUM_COLUMN_ID),res.getString(NUM_COLUMN_NAME), res.getString(NUM_COLUMN_DISC),res.getString(NUM_COLUMN_PIC));
            listTea.add(tea);
        }
        res.close();
        return listTea;
    }

    private static class OpenHelper extends SQLiteOpenHelper{
        public OpenHelper(Context context){
            super(context, BASENAME, null, DATA_BASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            String query = "CREATE TABLE "+ TABLE_NAME + " ( " +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " + COLUMN_DISC + " TEXT, "+
                    COLUMN_PIC + " TEXT);";
            sqLiteDatabase.execSQL(query);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(sqLiteDatabase);
        }
    }



}
