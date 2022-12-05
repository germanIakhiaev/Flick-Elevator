package com.techelevator.model;

import java.util.List;

public class Account {

    private int accountId;
    private int userId;
    private List preferredGenres; // ints!!!!!!!!!
    private List favoriteMovies;
    private List dislikedMovies;

    public Account(int accountId, int userId, List preferredGenres) {
        this.accountId = accountId;
        this.userId = userId;
        this.preferredGenres = preferredGenres;
    }
}
