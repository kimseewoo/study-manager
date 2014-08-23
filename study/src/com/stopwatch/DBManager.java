package com.stopwatch;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBManager extends SQLiteOpenHelper {
	final static String t_name = "myTable";
	
	public DBManager(Context context){
		super(context, "myDB", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table " + t_name +" (num INTEGER PRIMARY KEY AUTOINCREMENT," +
				"title text," + "memo text" +
				"year text," + "month text," + "day text," +
				"hour text," + "minute text," + "second text);" );
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
