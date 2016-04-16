package com.team.baseapp.baseapp.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * db helper
 * Created by lynnzc on 16-4-16.
 */
public class DbUtils extends SQLiteOpenHelper {
    public static final int DB_VERSION = 1;

    public DbUtils(Context context, String name) {
        super(context, name, null, DB_VERSION);
    }

    public DbUtils(Context context, String name, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
