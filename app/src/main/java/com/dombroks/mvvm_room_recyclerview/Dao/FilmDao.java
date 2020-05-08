package com.dombroks.mvvm_room_recyclerview.Dao;

import android.provider.ContactsContract;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.dombroks.mvvm_room_recyclerview.Model.Film;

import java.util.List;

@Dao
public interface FilmDao {
    @Insert
    void Insert(Film  film);
    @Update
    void Update(Film film);
    @Delete
    void Delete(Film film);
    @Query("DELETE FROM film_table")
    void DeleteAll();
    @Query("SELECT * FROM film_table")
    LiveData<List<Film>> getAllFilms();

}
