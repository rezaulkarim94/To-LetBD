package com.to_letbd.to_letbd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static  MyDatabaseHelper instance=null;

    public static String KEY_DATABASE_NAME="MY_DATABASE";
    public static int KEY_VERSION=1;

    public static String TABLE_NAME="STUDENT_TABLE";
    public static String contact="contact";
    public static String mail="mail";
    public static String name="name";
    public static String location="location";
    public static String details="details";
    public static String latitude="latitude";
    public static String longlatitude="longlatitude";

    public String CREATE_TABLE= "CREATE TABLE " + TABLE_NAME+" (" + contact + " TEXT,"+
            mail + " TEXT,"+ name + " TEXT,"+location + " TEXT,"+ details + " TEXT,"+latitude +
    " TEXT,"+ longlatitude + " TEXT);";

    private MyDatabaseHelper(Context context) {
        super(context, KEY_DATABASE_NAME, null, KEY_VERSION);
    }
    public static MyDatabaseHelper getInstance(Context context){
        if (instance==null){
            instance=new MyDatabaseHelper(context);
        }
        return instance;
    }
    private static final String KEY_DELETE_COMMAND="DROP TABLE "+TABLE_NAME+";";
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion<newVersion){
            db.execSQL(KEY_DELETE_COMMAND);
            this.onCreate(db);
        }

    }

    public long datainsert(AddInformation information){
        SQLiteDatabase writableDatabase = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(contact,information.getContactNO());
        values.put(mail,information.getMail());
        values.put(name,information.getName());
        values.put(location,information.getLocation());
        values.put(details,information.getDetails());
        values.put(latitude,information.getLatitude());
        values.put(longlatitude,information.getLonglatutide());
        long inserted = writableDatabase.insert(TABLE_NAME, null, values);
        writableDatabase.close();
        return inserted;
    }
   public ArrayList<AddInformation> getData(){
       ArrayList<AddInformation> allData=new ArrayList<>();
       SQLiteDatabase db = this.getReadableDatabase();
       Cursor cursor = db.rawQuery("select * from " + TABLE_NAME + "", null);
       if (cursor.moveToFirst()){
           while (cursor.moveToNext()){
               String contactinfo=cursor.getString(cursor.getColumnIndex(contact));
               String mailinfo=cursor.getString(cursor.getColumnIndex(mail));
               String nameinfo=cursor.getString(cursor.getColumnIndex(name));
               String locationinfo=cursor.getString(cursor.getColumnIndex(location));
               String detailsinfo=cursor.getString(cursor.getColumnIndex(details));
               double latidude=cursor.getDouble(cursor.getColumnIndex(latitude));
               double Longlatudite=cursor.getDouble(cursor.getColumnIndex(longlatitude));
               AddInformation student=new AddInformation(contactinfo,mailinfo,nameinfo,locationinfo,detailsinfo,latidude,Longlatudite);
               allData.add(student);
           }
       }
       return allData;
   }
//   public boolean update(Student student){
//       SQLiteDatabase writableDatabase = this.getWritableDatabase();
//       ContentValues values=new ContentValues();
//       values.put(NAME,student.getName());
//       values.put(ID,student.getId());
//       values.put(MOBILE,student.getMobile());
//      writableDatabase.update(TABLE_NAME, values, "ID = ?", new String[]{ID});
//       writableDatabase.close();
//       return true;
//   }
}
