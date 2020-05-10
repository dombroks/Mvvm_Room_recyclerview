package com.dombroks.mvvm_room_recyclerview.View.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dombroks.mvvm_room_recyclerview.Model.Film;
import com.dombroks.mvvm_room_recyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.Holder> {
    private List<Film> films = new ArrayList<>();
    private onItemClickListener listener;

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Film current=films.get(position);
        holder.tv_title.setText(current.getTitle());
        holder.tv_description.setText(current.getDescription());

    }

    @Override
    public int getItemCount() {
        return films.size() ;
    }

    class Holder extends RecyclerView.ViewHolder {
        private TextView tv_title;
        private TextView tv_description;

        public Holder(@NonNull View itemView) {
            super(itemView);
            tv_title=itemView.findViewById(R.id.tv_title) ;
            tv_description=itemView.findViewById(R.id.tv_description);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(films.get(position));
                    }
                }
            });

        }
    }

    public void setNotes(List<Film> films) {
        this.films = films;
        notifyDataSetChanged();
    }

    public Film getFilmAt(int position) {
        return films.get(position);
    }

    public interface onItemClickListener {
        void onItemClick(Film film);
    }

    public void setOnItemClickListener(onItemClickListener listener) {
        this.listener = listener;
    }
}
