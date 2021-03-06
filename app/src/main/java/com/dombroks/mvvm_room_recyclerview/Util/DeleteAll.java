package com.dombroks.mvvm_room_recyclerview.Util;

import android.os.AsyncTask;

import com.dombroks.mvvm_room_recyclerview.Dao.FilmDao;
import com.dombroks.mvvm_room_recyclerview.Model.Film;

public class DeleteAll extends AsyncTask <Film,Void ,Void>{
    private FilmDao filmDao;
    public DeleteAll(FilmDao filmDao){
        this.filmDao=filmDao;
    }
    @Override
    public Void doInBackground(Film... films) {
        filmDao.DeleteAll();
        return null;
    }
}
