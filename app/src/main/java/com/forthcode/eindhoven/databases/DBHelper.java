package com.forthcode.eindhoven.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.forthcode.eindhoven.R;
import com.forthcode.eindhoven.model.pNotification;

/**
 * Created by Chetan.Nayak on 2017-05-01.
 */

public class DBHelper extends SQLiteOpenHelper {

    boolean upgrade = false;
    SQLiteDatabase db;
    final Context context;


    @SuppressWarnings("static-access")
    public DBHelper(Context context, String name, CursorFactory factory) {
        super(context, name, factory, Integer.parseInt(context.getResources()
                .getString(R.string.app_db_version)));
        this.context = context;
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.v("MyDBhelper onCreate", "Creating all the tables");
        try {
            db.execSQL(pNotification.CREATE_TABLE());
        } catch (SQLiteException ex) {
            Log.v("Create table exception", ex.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("drop table if exists notification");
        onCreate(db);
    }
}