package com.dombroks.mvvm_room_recyclerview.DB;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.dombroks.mvvm_room_recyclerview.Dao.FilmDao;
import com.dombroks.mvvm_room_recyclerview.Model.Film;
import com.dombroks.mvvm_room_recyclerview.Dao.PopulateDB;

@Database(entities = Film.class, version = 2)
public abstract class FilmDB extends RoomDatabase {

    private static FilmDB instance;

    public abstract FilmDao filmDao();

    //synchronized here is for creating a single instance.
    public static synchronized FilmDB getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    FilmDB.class, "film_DB")
                    .addCallback(roomCallback)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new Callback() {
        private  PopulateDB populateDB ;
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            populateDB=new PopulateDB(instance);
            populateDB.execute();
            super.onCreate(db);
        }
    };


}
