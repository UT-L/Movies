package com.example.movies;

import androidx.annotation.DrawableRes;

public class Movie {
    private String title;
    private int year;
    private String genre;
    private int posterResId;
    public Movie(String title, int year, String genre, @DrawableRes int posterResId) {
        this.title = (title != null && !title.isEmpty()) ? title : "Unknown";
        this.year = (year > 1800) ? year : 0;
        this.genre = (genre != null && !genre.isEmpty()) ? genre : "Unknown";
        this.posterResId = (posterResId != 0) ? posterResId : R.drawable.default_poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = (title != null && !title.isEmpty()) ? title : "Unknown";
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = (year > 1800) ? year : 0;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = (genre != null && !genre.isEmpty()) ? genre : "Unknown";
    }

    public int getPosterResId() {
        return posterResId;
    }

    public void setPosterResId(@DrawableRes int posterResId) {
        this.posterResId = (posterResId != 0) ? posterResId : R.drawable.default_poster;
    }
}
