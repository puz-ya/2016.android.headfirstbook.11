package com.yd.starcoffeesql;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by YD on 09.01.2017.
 */

public class StarCoffeeSQLHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "starcoffee_db";   //db name
    public static final int DB_VERSION = 1; //db version
    public static final String TABLE_NAME = "DRINKS";

    StarCoffeeSQLHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE "+TABLE_NAME+" (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME TEXT, " +
                "DESCRIPTION TEXT, " +
                "IMAGE INTEGER); ");

        insertDrink(db, "Latte", "Espresso and steamed milk", R.drawable.latte);
        insertDrink(db, "Cappuccino", "Espresso, hot milk and steamed-milk foam",
                R.drawable.cappuccino);
        insertDrink(db, "Filter", "Our best drip coffee", R.drawable.filter);
    }

    public void insertDrink(SQLiteDatabase db, String name, String descr, int imageID){
        ContentValues drinkValues = new ContentValues();
        drinkValues.put("NAME", name);
        drinkValues.put("DESCRIPTION", descr);
        drinkValues.put("IMAGE", imageID);
        db.insert(TABLE_NAME, null, drinkValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
