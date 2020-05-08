package com.dombroks.mvvm_room_recyclerview.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import com.dombroks.mvvm_room_recyclerview.Model.Film;
import com.dombroks.mvvm_room_recyclerview.R;
import com.dombroks.mvvm_room_recyclerview.ViewModel.FilmViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.io.File;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FilmViewModel filmViewModel;
    public static final int ADD_REQUEST=1 ;
    public static final int EDIT_REQUEST=2;
    private FloatingActionButton floatingActionButton ;
    private TextView title;
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filmViewModel=new ViewModelProvider(this).get(FilmViewModel.class);
        filmViewModel.getAllNotes().observe(new Observer<List<Film>>() {
            @Override
            public void onChanged(List<Film> films) {
                
            }
        });
    }
}
