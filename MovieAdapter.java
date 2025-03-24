package com.example.movies;

import android.view.*;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.*;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private List<Movie> movies;

    public MovieAdapter(List<Movie> movies) { this.movies = movies; }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);

        if (movie != null) {
            holder.title.setText(movie.getTitle() != null ? movie.getTitle() : "Unknown Title");
            holder.year.setText(movie.getYear() > 0 ? String.valueOf(movie.getYear()) : "Unknown Year");
            holder.genre.setText(movie.getGenre() != null ? movie.getGenre() : "Unknown Genre");
        }
    }


    @Override
    public int getItemCount() { return movies.size(); }

    static class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView title, year, genre;
        public MovieViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.movieTitle);
            year = itemView.findViewById(R.id.movieYear);
            genre = itemView.findViewById(R.id.movieGenre);
        }
    }
}

