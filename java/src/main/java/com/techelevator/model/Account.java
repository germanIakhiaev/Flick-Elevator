package com.techelevator.model;

import java.util.List;

public class Account {

    private int accountId;
    private int userId;
    private List<Integer> preferredGenres;
    private List<Integer> getLikedMovies;
    private List<Integer> favoriteMovies;
    private List<Integer> dislikedMovies;

    public Account() {}

    public Account(int accountId, int userId, List<Integer> preferredGenres) {
        this.accountId = accountId;
        this.userId = userId;
        this.preferredGenres = preferredGenres;
    }

    public Account(int accountId, int userId, List<Integer> preferredGenres, List<Integer> getLikedMovies, List<Integer> favoriteMovies, List<Integer> dislikedMovies) {
        this.accountId = accountId;
        this.userId = userId;
        this.preferredGenres = preferredGenres;
        this.getLikedMovies = getLikedMovies;
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

    public List<Integer> getGetLikedMovies() {
        return getLikedMovies;
    }

    public List<Integer> getFavoriteMovies() {
        return favoriteMovies;
    }

    public List<Integer> getDislikedMovies() {
        return dislikedMovies;
    }
}
