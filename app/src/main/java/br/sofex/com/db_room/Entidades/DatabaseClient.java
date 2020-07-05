package br.sofex.com.db_room.Entidades;

import android.content.Context;

import androidx.room.Room;

import br.sofex.com.db_room.DB.RoomDataBase.RoomDatabaseDB;

/*
    * Database Client
    * Creating AppDatabase’s object is expensive so we will create a single instance of it.
    * Create a class named DatabaseClient and write the following code.
    */
public class DatabaseClient {

    private Context mCtx;
    private static DatabaseClient mInstance;
    private static final String DB_NAME = "DATABASE.db";

        //our app database object
        private RoomDatabaseDB appDatabase;

        private DatabaseClient(Context mCtx , String DataBaseName) {
            this.mCtx = mCtx;
            //creating the app database with Room database builder
            //MyToDos is the name of the database
            appDatabase = Room.databaseBuilder(mCtx, RoomDatabaseDB.class, DataBaseName).build();
        }

        public static synchronized DatabaseClient getInstance(Context mCtx) {
          if (mInstance == null) { mInstance = new DatabaseClient(mCtx,DB_NAME);}
          return mInstance;
        }

        public RoomDatabaseDB getAppDatabase() {
            return appDatabase;
        }

}
