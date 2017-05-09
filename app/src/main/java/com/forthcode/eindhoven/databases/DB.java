package com.forthcode.eindhoven.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import com.forthcode.eindhoven.model.pNotification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chetan.Nayak on 2017-05-02.
 */

public class DB {
    private final Context context;
    private final DBHelper dbhelper;
    private SQLiteDatabase db;

    public DB(Context paramContext) {
        this.context = paramContext;
        this.dbhelper = new DBHelper(this.context, "eindhoven.db", null);
    }

    public void open() throws SQLiteException {
        try {
            this.db = this.dbhelper.getWritableDatabase();
            return;
        } catch (SQLiteException localSQLiteException) {
            Log.v("OpenDB exception caught", localSQLiteException.getMessage());
            this.db = this.dbhelper.getReadableDatabase();
        }
    }

    public void close() {
        this.db.close();
    }

    public boolean insertPushMsg(String ptitle, String pmessage) {
        db.beginTransaction();
        ContentValues values = new ContentValues();
        values.put(pNotification.P_TITLE, ptitle);
        values.put(pNotification.P_MESSGAE, pmessage);
        // Inserting Row
        int count = (int) db.insert(pNotification.TABLE_NAME, null, values);

        if (count > 0) {
            db.setTransactionSuccessful();
            db.endTransaction();
            db.close();
            return true;
        } else {
            db.endTransaction();
            db.close();
            return false;
        }
         // Closing database connection
    }

    public ArrayList<Map<String, String>> GetallNotification() {
        ArrayList<Map<String, String>> detailStatus = new ArrayList<Map<String, String>>();
        Cursor c = db.query(pNotification.TABLE_NAME, null, null, null, null, null, pNotification.P_ID+" DESC");
        try {
            c.moveToFirst();
            while (!c.isAfterLast()) {
                Map<String, String> map = new HashMap<String, String>();
                for (int i = 0; i < c.getColumnCount(); i++) {
                    map.put(c.getColumnName(i), c.getString(i));
                }
                detailStatus.add(map);
                c.moveToNext();
            }
        } finally {
            c.close();
        }
        return detailStatus;
    }

}
