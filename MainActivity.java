package com.example.movies;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MovieAdapter adapter;
    private TextView errorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        errorMessage = findViewById(R.id.errorTextView); // Add a TextView for errors

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Movie> movies = JSONUtility.loadMovies(this, "movie_data.json");

        if (movies.isEmpty()) {
            errorMessage.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
            errorMessage.setText("Error loading movies. Please check the JSON file.");
        } else {
            errorMessage.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            adapter = new MovieAdapter(movies);
            recyclerView.setAdapter(adapter);
        }
    }
}
