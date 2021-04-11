package com.example.smartpolicestation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper
{
    //public final static String DATABASE_NAME="User.db";
    //public final static String TABLE_NAME="usertable";
    //public final static String COL_1="NUMBER";
    //public final static String COL_2="PASSWORD";


    // public final static String COL_3="FEEDBACK";
    //public final static String COL_4="RATE";
    //public final static String COL_5="COMPLAIN";


    public DatabaseHelper(Context context)
    {
        super(context,"User.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create Table usertable (number text primary key,password text,name text,aadhar text,email text,complaint text,rate text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS usertable");
        onCreate(db);

    }

    public boolean createUser(String newNumber,String newPassword)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("number",newNumber);
        cv.put("password",newPassword);
        long result=db.insert("usertable",null,cv);
        if(result==-1) {
            return false;
        }
        else {

            return true;
        }
    }


    public boolean check(String number,String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String query="select * from usertable where number='"+number+"' and password='"+password+"'";
        Cursor c=db.rawQuery(query,null);
        if(c.getCount()<=0)
        {
            c.close();
            db.close();
            return false;
        }
        else
        {
            c.close();
            db.close();
            return true;
        }
    }

    public boolean register(String comNumber,String name,String aadhar,String email,String complaint)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("number",comNumber);
        cv.put("name",name);
        cv.put("aadhar",aadhar);
        cv.put("email",email);
        cv.put("complaint",complaint);
        db.update("usertable",cv,"number=?",new String[]{comNumber});
        return true;

    }





}
