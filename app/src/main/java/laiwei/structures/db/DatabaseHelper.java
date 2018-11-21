package laiwei.structures.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by laiwei on 2018/11/20 0020.
 */
public final class DatabaseHelper extends SQLiteOpenHelper{

    private static final String DB_NAME = "structure_db";
    private static final String TABLE_NAME = "user";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "_name";
    public static final String COLUMN_PWD = "_pwd";

    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
            + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_NAME + " TEXT ," + COLUMN_PWD + " TEXT ) ";


    private static DatabaseHelper helper;

    private DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static DatabaseHelper getInstance(Context context){
        if(helper == null){
            helper = new DatabaseHelper(context,DB_NAME,null,1);
        }
        return helper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL(CREATE_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME); //$NON-NLS-1$
        onCreate(db);
    }

    public long insert(ContentValues values) {
        return helper.getWritableDatabase().insert(TABLE_NAME,null,values);
    }

}
