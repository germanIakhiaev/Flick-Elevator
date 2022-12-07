package com.techelevator.model;

import java.util.List;

public class Account {

    private int accountId;
    private int userId;
    private String preferredGenres;
    private String likedMovies;
    private String favoriteMovies;
    private String dislikedMovies;

    public Account() {}


    public Account(int accountId, int userId, String preferredGenres, String likedMovies, String favoriteMovies, String dislikedMovies) {
        this.accountId = accountId;
        this.userId = userId;
        this.preferredGenres = preferredGenres;
        this.likedMovies = likedMovies;
        this.favoriteMovies = favoriteMovies;
        this.dislikedMovies = dislikedMovies;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getUserId() {
        return userId;
    }

    public String getPreferredGenres() {
        return preferredGenres;
    }

    public String getLikedMovies() {
        return likedMovies;
    }

    public String getFavoriteMovies() {
        return favoriteMovies;
    }

    public String getDislikedMovies() {
        return dislikedMovies;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setPreferredGenres(String preferredGenres) {
        this.preferredGenres = preferredGenres;
    }

    public void setLikedMovies(String likedMovies) {
        this.likedMovies = likedMovies;
    }

    public void setFavoriteMovies(String favoriteMovies) {
        this.favoriteMovies = favoriteMovies;
    }

    public void setDislikedMovies(String dislikedMovies) {
        this.dislikedMovies = dislikedMovies;
    }
}
