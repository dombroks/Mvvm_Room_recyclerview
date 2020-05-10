package com.dombroks.mvvm_room_recyclerview.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Film_Table")
public class Film {


    @PrimaryKey(autoGenerate = true)
    private int id ;

    private String title;
    private String description;

    public Film(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }
}
