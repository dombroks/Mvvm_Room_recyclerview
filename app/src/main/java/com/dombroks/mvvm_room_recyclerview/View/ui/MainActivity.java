package com.dombroks.mvvm_room_recyclerview.View.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dombroks.mvvm_room_recyclerview.View.Adapter.FilmAdapter;
import com.dombroks.mvvm_room_recyclerview.Model.Film;
import com.dombroks.mvvm_room_recyclerview.R;
import com.dombroks.mvvm_room_recyclerview.ViewModel.FilmViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FilmViewModel filmViewModel;
    public static final int ADD_REQUEST = 1;
    public static final int EDIT_REQUEST = 2;
    private FloatingActionButton floatingActionButton;
    private TextView title;
    private TextView description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final FilmAdapter adapter = new FilmAdapter();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        filmViewModel = new ViewModelProvider(this).get(FilmViewModel.class);
        filmViewModel.getAllNotes().observe(this, new Observer<List<Film>>() {
            @Override
            public void onChanged(List<Film> films) {
                adapter.setNotes(films);
            }
        });
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                filmViewModel.delete(adapter.getFilmAt(viewHolder.getAdapterPosition()));
            }
        }).attachToRecyclerView(recyclerView);
        adapter.setOnItemClickListener(new FilmAdapter.onItemClickListener() {
            @Override
            public void onItemClick(Film film) {
                Intent intent = new Intent(MainActivity.this, AddEditFilm.class);
                intent.putExtra(AddEditFilm.ID, film.getId());
                intent.putExtra(AddEditFilm.DESCRIPTION, film.getDescription());
                intent.putExtra(AddEditFilm.TITLE, film.getTitle());
                startActivityForResult(intent, EDIT_REQUEST);
            }
        });
        floatingActionButton = findViewById(R.id.add_film);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddEditFilm.class);
                startActivityForResult(intent, ADD_REQUEST);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_REQUEST && resultCode == RESULT_OK) {
            String title = data.getStringExtra(AddEditFilm.TITLE);
            String description = data.getStringExtra(AddEditFilm.DESCRIPTION);

            Film film = new Film(title, description);
            filmViewModel.insert(film);
            Toast.makeText(this, "Film saved", Toast.LENGTH_SHORT).show();
        } else if (requestCode == EDIT_REQUEST && resultCode == RESULT_OK) {
            int id = data.getIntExtra(AddEditFilm.ID, -1);
            if (id == -1) {
                Toast.makeText(this, "Film can't be updated", Toast.LENGTH_SHORT).show();
                return;
            }
            String title = data.getStringExtra(AddEditFilm.TITLE);
            String description = data.getStringExtra(AddEditFilm.DESCRIPTION);

            Film film = new Film(title, description);
            film.setId(id);
            filmViewModel.update(film);
            Toast.makeText(MainActivity.this, "Film updated", Toast.LENGTH_SHORT).show();

        } else Toast.makeText(this, "Not saved...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.deleteAllFilms:
                filmViewModel.deleteAllNotes();
                Toast.makeText(MainActivity.this, "All films are deleted", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
