package com.dombroks.mvvm_room_recyclerview.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.dombroks.mvvm_room_recyclerview.Model.Film;
import com.dombroks.mvvm_room_recyclerview.Repository.FilmRepository;

import java.util.List;

public class FilmViewModel extends AndroidViewModel {
    private FilmRepository repository ;
    private LiveData<List<Film>> allFilms ;

    public FilmViewModel(Application application) {
        super(application);
        repository=new FilmRepository(application);
        allFilms=repository.getAllFilms();
    }
    public void insert(Film film){
        repository.insert(film);
    }
    public void update(Film film){
        repository.update(film);
    }
    public void delete(Film film){
        repository.delete(film);
    }
    public void deleteAllNotes(){
        repository.deleteAllFilms();
    }
    public LiveData<List<Film>> getAllNotes(){
        return allFilms ;
    }

}
