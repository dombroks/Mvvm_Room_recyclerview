package com.dombroks.mvvm_room_recyclerview.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.dombroks.mvvm_room_recyclerview.DB.FilmDB;
import com.dombroks.mvvm_room_recyclerview.Dao.FilmDao;
import com.dombroks.mvvm_room_recyclerview.Model.Film;
import com.dombroks.mvvm_room_recyclerview.Operations.DeleteAll;
import com.dombroks.mvvm_room_recyclerview.Operations.InsertFilm;
import com.dombroks.mvvm_room_recyclerview.Operations.UpdateFilm;

import java.util.List;

public class FilmRepository {
    private FilmDao filmDao;
    private LiveData<List<Film>> allFilms;

    public FilmRepository(Application application) {
        FilmDB filmDB = FilmDB.getInstance(application);
        filmDao = filmDB.filmDao();
        allFilms = filmDao.getAllFilms();
    }

    public void insert(Film film) {
        new InsertFilm(filmDao).execute(film);
    }

    public void update(Film film) {
        new UpdateFilm(filmDao).execute(film);
    }

    public void delete() {
        new DeleteAll(filmDao).execute();
    }

    public void deleteAllFilms() {
        new DeleteAll(filmDao).execute();
    }

    public LiveData<List<Film>> getAllFilms() {
    return allFilms;
    }
}
