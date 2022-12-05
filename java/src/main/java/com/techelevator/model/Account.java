package com.techelevator.model;

import java.util.List;

public class Account {

    private int accountId;
    private int userId;
    private List<Integer> preferredGenres;
    private List<Integer> getLikedMovies;
    private List<Integer> favoriteMovies;
    private List<Integer> dislikedMovies;

    public Account(int accountId, int userId, List<Integer> preferredGenres) {
        this.accountId = accountId;
        this.userId = userId;
        this.preferredGenres = preferredGenres;
    }
}
