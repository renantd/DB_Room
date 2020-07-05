package br.sofex.com.db_room.DB.RoomDataBase;

import android.content.Context;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import br.sofex.com.db_room.DB.DAO.PessoaDao;
import br.sofex.com.db_room.Entidades.Pessoa;
import br.sofex.com.db_room.Entidades.Sqlite;

@Database(entities = {Pessoa.class}, version = 1, exportSchema = false)
public abstract class RoomDatabaseDB extends RoomDatabase {


        public abstract PessoaDao pessaoDao();
        private static volatile RoomDatabaseDB INSTANCE;
        private static final String DB_NAME = "Slqite.db";


        private static final int NUMBER_OF_THREADS = 4;
        static final ExecutorService databaseWriteExecutor =
        Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        public  RoomDatabaseDB getDatabase(final Context context) {
            if (INSTANCE == null) {
                synchronized (RoomDatabaseDB.class) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                         //Este nome do banco de dados não é utilizado
                         RoomDatabaseDB.class,DB_NAME).build();
                    }
                }
            }

        return INSTANCE;

    }

}
