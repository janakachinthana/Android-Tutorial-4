package com.janaka.tute4.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "UserInfo.db";

    public DBHelper( Context context){ super( context, DATABASE_NAME, null, 1 ); }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + UserMaster.Users.TABLE_NAME + " (" +
                        UserMaster.Users._ID + " INTEGER PRIMARY KEY," +
                        UserMaster.Users.COLUMN_NAME_USERNAME + " TEXT," +
                        UserMaster.Users.COLUMN_NAME_PASSWORD + " TEXT)";

        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addInfo(String userName, String password){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put( UserMaster.Users.COLUMN_NAME_USERNAME, userName );
        values.put( UserMaster.Users.COLUMN_NAME_PASSWORD, password );

        long newRowId = db.insert( UserMaster.Users.TABLE_NAME, null, values );

    }

    public List ReadAllInfo() {

        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                UserMaster.Users._ID,
                UserMaster.Users.COLUMN_NAME_USERNAME,
                UserMaster.Users.COLUMN_NAME_PASSWORD
        };

        String sortOrders = UserMaster.Users.COLUMN_NAME_USERNAME + " DESC";

        Cursor cursor = db.query(
                UserMaster.Users.TABLE_NAME,
                projection,
                null,
                null,
                null,
                sortOrders
        );

        List userNames = new ArrayList<>();
        List passwords = new ArrayList();

        while(cursor.moveToNext()){
            String username = cursor.getString( cursor.getColumnIndexOrThrow( UserMaster.Users.COLUMN_NAME_USERNAME ));
            String password = cursor.getString( cursor.getColumnIndexOrThrow( UserMaster.Users.COLUMN_NAME_PASSWORD ));
            userNames.add( username );
            passwords.add( password );
        }
        cursor.close();
        return userNames;
    }

    public void readInfo(){

    }

    public void deleteInfo(String userName){
    SQLiteDatabase db = getReadableDatabase();

    String selection = UserMaster.Users.COLUMN_NAME_USERNAME + " LIKE ?";
    String[] selectionArgs = { userName };

    db.delete( UserMaster.Users.TABLE_NAME, selection, selectionArgs );

    }

    public void updateInfo(String userName, String password){
        SQLiteDatabase db = getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put( UserMaster.Users.COLUMN_NAME_PASSWORD, password);

        String selection = UserMaster.Users.COLUMN_NAME_USERNAME + " LIKE ?";
        String[] selectionArgs = {userName};

        int count = db.update(
                UserMaster.Users.TABLE_NAME,
                values,
                selection,
                selectionArgs
        );
    }
}

