package com.techelevator.model;

import java.util.List;

public class Account {

    private int accountId;
    private int userId;
    private List<Integer> preferredGenres;
    private List<Integer> likedMovies;
    private List<Integer> favoriteMovies;
    private List<Integer> dislikedMovies;

    public Account() {}


    public Account(int accountId, int userId, List<Integer> preferredGenres, List<Integer> likedMovies, List<Integer> favoriteMovies, List<Integer> dislikedMovies) {
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

    public List<Integer> getPreferredGenres() {
        return preferredGenres;
    }

    public List<Integer> getLikedMovies() {
        return likedMovies;
    }

    public List<Integer> getFavoriteMovies() {
        return favoriteMovies;
    }

    public List<Integer> getDislikedMovies() {
        return dislikedMovies;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setPreferredGenres(List<Integer> preferredGenres) {
        this.preferredGenres = preferredGenres;
    }

    public void setLikedMovies(List<Integer> likedMovies) {
        this.likedMovies = likedMovies;
    }

    public void setFavoriteMovies(List<Integer> favoriteMovies) {
        this.favoriteMovies = favoriteMovies;
    }

    public void setDislikedMovies(List<Integer> dislikedMovies) {
        this.dislikedMovies = dislikedMovies;
    }
}
