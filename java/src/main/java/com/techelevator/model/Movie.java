package com.techelevator.model;

import java.time.LocalDate;
import java.util.List;

public class Movie {

    private int id;
    private String title;
    private List<Integer> genres;
    private LocalDate release_date;
    private String overview;
    private double popularity;
    private int runtime;
    private String tagline;
    private String poster_path;

    public Movie() {}

    public Movie(int id, String title, List<Integer> genres, LocalDate release_date, String overview, double popularity, int runtime, String tagline, String poster_path) {
        this.id = id;
        this.title = title;
        this.genres = genres;
        this.release_date = release_date;
        this.overview = overview;
        this.popularity = popularity;
        this.runtime = runtime;
        this.tagline = tagline;
        this.poster_path = poster_path;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Integer> getGenres() {
        return genres;
    }

    public LocalDate getRelease_date() {
        return release_date;
    }

    public String getOverview() {
        return overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public int getRuntime() {
        return runtime;
    }

    public String getTagline() {
        return tagline;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenres(List<Integer> genres) {
        this.genres = genres;
    }

    public void setRelease_date(LocalDate release_date) {
        this.release_date = release_date;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}
