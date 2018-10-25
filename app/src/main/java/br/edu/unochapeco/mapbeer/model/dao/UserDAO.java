package br.edu.unochapeco.mapbeer.model.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.edu.unochapeco.mapbeer.db.DBHandler;
import br.edu.unochapeco.mapbeer.model.vo.UserVO;

import static java.lang.Boolean.valueOf;
import static java.lang.Integer.parseInt;

public class UserDAO extends AbstractDAO {

    public UserDAO(final Context context){
        DATABASE = new DBHandler(context, DATABASE_NAME, null, VERSION);
    }

    public String save(final Integer id, final String name, final String password, final Boolean islogged){
        final ContentValues values = new ContentValues();
        final long result;

        DB = DATABASE.getWritableDatabase();

        values.put(DBHandler.ID_USER, id);
        values.put(DBHandler.NAME_USER, name);
        values.put(DBHandler.PASSWORD_USER, password);
        values.put(DBHandler.ISLOGGED_USER, islogged);

        result = DB.insert(DBHandler.TABLE_USER, null, values);

        DB.close();

        return (result == -1) ? "Failure to persist data" : "Success to persist data";
    }

    @SuppressLint("Recycle")
    public List<UserVO> retriveAll(){
        final Cursor cursor;
        final List<UserVO> listUsers = new ArrayList<>();
        final String[] columns =  {DBHandler.ID_USER, DBHandler.NAME_USER};
        UserVO user;

        DB = DATABASE.getReadableDatabase();

        cursor = DB.query(DBHandler.TABLE_USER, columns, null, null, null, null, null, null);

        if(cursor!=null){
            while(cursor.moveToNext()) {
                user = new UserVO(parseInt(cursor.getString(cursor.getColumnIndex(DBHandler.ID_USER))),
                                  cursor.getString(cursor.getColumnIndex(DBHandler.NAME_USER)),
                                  cursor.getString(cursor.getColumnIndex(DBHandler.PASSWORD_USER)),
                                  valueOf(cursor.getString(cursor.getColumnIndex(DBHandler.ISLOGGED_USER))));
                listUsers.add(user);
            }
        }

        DB.close();

        return listUsers;
    }
}
