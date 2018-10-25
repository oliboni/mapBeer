package br.edu.unochapeco.mapbeer.model.dao;

import android.database.sqlite.SQLiteDatabase;

import br.edu.unochapeco.mapbeer.db.DBHandler;

public abstract class AbstractDAO {

    protected static final String DATABASE_NAME = "mapbeer.db";
    protected static final int VERSION = 1;
    protected SQLiteDatabase DB;
    protected DBHandler DATABASE;
}
