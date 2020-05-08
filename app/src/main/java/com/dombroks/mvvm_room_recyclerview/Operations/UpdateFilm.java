package com.dombroks.mvvm_room_recyclerview.Operations;

import android.os.AsyncTask;

import com.dombroks.mvvm_room_recyclerview.Dao.FilmDao;
import com.dombroks.mvvm_room_recyclerview.Model.Film;

public class UpdateFilm extends AsyncTask <Film,Void,Void>{
    private FilmDao filmDao;
    public UpdateFilm(FilmDao filmDao){
        this.filmDao=filmDao;
    }
    @Override
    public Void doInBackground(Film... films) {
        filmDao.Update(films[0]);
        return null;
    }
}
