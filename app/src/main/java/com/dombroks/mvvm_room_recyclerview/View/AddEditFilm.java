package com.dombroks.mvvm_room_recyclerview.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.dombroks.mvvm_room_recyclerview.R;

public class AddEditFilm extends AppCompatActivity {
    public static final String ID =
            "com.dombroks.mvvm_room_recyclerview.ID";
    public static final String TITLE =
            "com.dombroks.mvvm_room_recyclerview.TITLE";
    public static final String DESCRIPTION =
            "com.dombroks.mvvm_room_recyclerview.DESCRIPTION";
    private EditText Title;
    private EditText Description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_film);

        Title = findViewById(R.id.et_title);
        Description = findViewById(R.id.et_description);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        Intent intent = getIntent();
        if (intent.hasExtra(ID)) {
            setTitle("Edit Film");
            Title.setText(intent.getStringExtra(TITLE));
            Description.setText(intent.getStringExtra(DESCRIPTION));
        } else
            setTitle("Add Film");
    }

    private void saveFilm() {
        String title = Title.getText().toString();
        String description = Description.getText().toString();
        if (title.trim().isEmpty() || description.trim().isEmpty()) {
            Toast.makeText(AddEditFilm.this, "Please fill all the champs", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent data = new Intent();
        data.putExtra(TITLE, title);
        data.putExtra(DESCRIPTION, description);

        int id = getIntent().getIntExtra(ID, -1);
        if (id != -1) {
            data.putExtra(ID, id);
        }
        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_film, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.seve_film:
                saveFilm();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
