package com.techelevator.dao;

import com.techelevator.model.Account;

import java.util.List;

public interface AccountDao {

    Account getAccountByAccountId(int accountId);

    Account getAccountByUserId(int userId);

    String[] getPreferredGenres(int accountId);

    String[] getLikedMovies(int accountId);

    String[] getFavoriteMovies(int accountId);

    String[] getDislikedMovies(int accountId);

    Account createAccount(int userId); //TODO: boolean?

    Account updateAccount(int accountId, int userId, List<Integer> preferredGenres, List<Integer> getLikedMovies, List<Integer> favoriteMovies, List<Integer> dislikedMovies);

    boolean deleteAccount(int accountId);
}
