package com.example.mess_menu;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database_info {
	public static final String Key_Rowid="_id";
	public static final String Key_Day="_day";
	public static final String Key_Time1="_brekfast";
	public static final String Key_Time2="_lunch";
	public static final String Key_Time3="_snacks";
	public static final String Key_Time4="_dinner";
	
	private static final String DB_name = "mess_info.db";
	//private static final String DB_table = "menu_info";
	private static final int DB_version = 1;
	
	private DBHELPER ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;
	
	
	private static class DBHELPER extends SQLiteOpenHelper {

		public DBHELPER(Context context) {
			super(context, DB_name, null, DB_version);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
		/*	db.execSQL("CREATE TABLE " + DB_table + " ("+
			Key_Rowid+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
					Key_Day + " TEXT NOT NULL, " +
			Key_Time1 + " TEXT NOT NULL, " +
			Key_Time2 + " TEXT NOT NULL, " +
			Key_Time3 + " TEXT NOT NULL, " +
			Key_Time4 + " TEXT NOT NULL);"
					);
			db.execSQL("INSERT INTO " + DB_table + " VALUES(1,'MOnday','BBJ','RICE-DAL','SAMOSA','PBM-NAAN');");
			*/
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
			// TODO Auto-generated method stub
			//db.execSQL("DROP TABLE IF EXISTS " + DB_table);
			//onCreate(db);
		}
	}
	
	public Database_info (Context c){
		ourContext =c;
	}
	public Database_info open()
	{
		ourHelper=new DBHELPER(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}
	public void close()
	{
		ourHelper.close();
		
	}
	public String getData(String DB_table) {
		// TODO Auto-generated method stub
		String[] columns=new String[]{Key_Rowid,Key_Day,Key_Time1,Key_Time2,Key_Time3,Key_Time4};
		Cursor c=ourDatabase.query(DB_table,columns, null, null, null, null, null);
		String result="";
	//	int irow=c.getColumnIndex(Key_Rowid);
		int iday=c.getColumnIndex(Key_Day);
		int itime1=c.getColumnIndex(Key_Time1);
		int itime2=c.getColumnIndex(Key_Time2);
		int itime3=c.getColumnIndex(Key_Time3);
		int itime4=c.getColumnIndex(Key_Time4);
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
		{
			result=result+ c.getString(iday) +
					" || " + c.getString(itime1) +" || " + c.getString(itime2) +
					" || " + c.getString(itime3) +
					" || " + c.getString(itime4) +"\n";
		}
		return result;
	}
	}
	
	
	

