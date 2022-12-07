package com.techelevator.dao;

import com.techelevator.model.Account;

import java.util.List;

public interface AccountDao {

    Account getAccountByAccountId(int accountId);

    Account getAccountByUserId(int userId);

    String getPreferredGenres(int accountId);

    String getLikedMovies(int accountId);

    String getFavoriteMovies(int accountId);

    String getDislikedMovies(int accountId);

    Account createAccount(int userId); //TODO: boolean?

    Account updateLikedMovies(int accountId, String updatedLikes);

    Account updateDislikedMovies(int accountId, String updatedDislikes);

    Account updateFavorites(int accountId, String updatedFavorites);

    Account updatePreferredGenres(int accountId, String updatedGenres);

    boolean deleteAccount(int accountId);
}
