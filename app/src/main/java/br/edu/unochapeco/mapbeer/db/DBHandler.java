package br.edu.unochapeco.mapbeer.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    public static final String TABLE_USER = "user";
    public static final String ID_USER = "id";
    public static final String NAME_USER = "name";
    public static final String PASSWORD_USER = "password";
    public static final String ISLOGGED_USER = "islogged";


    public DBHandler(final Context context, final String name, final CursorFactory factory, final int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(final SQLiteDatabase db) {
        final String sqlUser = "CREATE TABLE "+TABLE_USER+"("
                + ID_USER + " integer primary key autoincrement,"
                + NAME_USER + " text,"
                + NAME_USER + " text,"
                + ISLOGGED_USER + " boolean "
                +")";

        db.execSQL(sqlUser);
        this.populate(db);
    }

    @Override
    public void onUpgrade(final SQLiteDatabase db, final int oldVersion, final int newVersion) {
        db.execSQL("DROP TABLE IFEXISTS" + TABLE_USER);
        onCreate(db);
    }

    public void populate(final SQLiteDatabase db) {
        final String sql = "INSERT INTO "+TABLE_USER+"("+ID_USER+","+NAME_USER+","+PASSWORD_USER+", "+ISLOGGED_USER+") VALUES (-1, 'admin', '123456', 'true')";
        db.execSQL(sql);
    }

}
