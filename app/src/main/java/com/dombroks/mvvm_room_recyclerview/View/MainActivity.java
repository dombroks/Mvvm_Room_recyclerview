package com.dombroks.mvvm_room_recyclerview.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.dombroks.mvvm_room_recyclerview.R;
import com.dombroks.mvvm_room_recyclerview.ViewModel.FilmViewModel;

public class MainActivity extends AppCompatActivity {
    private FilmViewModel filmViewModel;
    public static final int ADD_REQUEST=1 ;
    public static final int EDIT_REQUEST=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
