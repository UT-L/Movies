package com.example.movies;

import android.content.Context;
import org.json.*;
import java.io.*;
import java.util.*;

public class JSONUtility {
    public static List<Movie> loadMovies(Context context, String filename) {
        List<Movie> movies = new ArrayList<>();
        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            String json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String title = obj.optString("title", "Unknown");
                int year = obj.optInt("year", 0);
                String genre = obj.optString("genre", "Unknown");
                String posterName = obj.optString("poster", "default_poster");

                int posterResId = context.getResources().getIdentifier(posterName, "drawable", context.getPackageName());
                if (posterResId == 0) {
                    posterResId = R.drawable.default_poster;
                }

                movies.add(new Movie(title, year, genre, posterResId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }
}
