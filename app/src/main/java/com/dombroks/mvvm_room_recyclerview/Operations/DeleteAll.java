package com.dombroks.mvvm_room_recyclerview.Operations;

import android.os.AsyncTask;

import com.dombroks.mvvm_room_recyclerview.Dao.FilmDao;

public class DeleteAll extends AsyncTask <Void,Void ,Void>{
    private FilmDao filmDao;
    public DeleteAll(FilmDao filmDao){
        this.filmDao=filmDao;
    }
    @Override
    public Void doInBackground(Void... Voids) {
        filmDao.DeleteAll();
        return null;
    }
}
