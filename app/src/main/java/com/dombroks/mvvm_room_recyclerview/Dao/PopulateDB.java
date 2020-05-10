package com.dombroks.mvvm_room_recyclerview.Dao;

import android.os.AsyncTask;

import com.dombroks.mvvm_room_recyclerview.DB.FilmDB;
import com.dombroks.mvvm_room_recyclerview.Dao.FilmDao;
import com.dombroks.mvvm_room_recyclerview.Model.Film;

public class PopulateDB extends AsyncTask<Void,Void,Void> {
   private FilmDao filmDao;

    public PopulateDB(FilmDB filmDB) {
        this.filmDao = filmDB.filmDao();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        filmDao.Insert(new Film("The green mile","Drama"));
        filmDao.Insert(new Film("The fast and the furious","Action"));
        filmDao.Insert(new Film("Cast away","Drama"));
        filmDao.Insert(new Film("Cast awadsfy", "Draedfma"));
        return null;
    }
}
