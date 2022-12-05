package com.techelevator.model;

import java.time.LocalDate;
import java.util.List;

public class Movie {

    private int id;
    private String title;
    private List genreList;
    private LocalDate releaseDate;
    private String overview;
    private double popularity;
    private int runtime;
    private String tagline;

    // private String posterPath;
    // private String status;

    public Movie() {}

    public Movie(int id, String title, List genreList) {
        this.id = id;
        this.title = title;
        this.genreList = genreList;
    }

    public Movie(int id, String title, List genreList, LocalDate releaseDate, String overview, double popularity, int runtime, String tagline) {
        this.id = id;
        this.title = title;
        this.genreList = genreList;
        this.releaseDate = releaseDate;
        this.overview = overview;
        this.popularity = popularity;
        this.runtime = runtime;
        this.tagline = tagline;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List getGenreList() {
        return genreList;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
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
}
