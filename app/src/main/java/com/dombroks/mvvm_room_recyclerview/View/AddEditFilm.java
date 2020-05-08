package com.dombroks.mvvm_room_recyclerview.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.NumberPicker;

import com.dombroks.mvvm_room_recyclerview.R;

public class AddEditFilm extends AppCompatActivity {
    private EditText Title;
    private EditText Description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_film);
    }
}
