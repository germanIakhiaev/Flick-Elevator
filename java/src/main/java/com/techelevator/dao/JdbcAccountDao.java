package com.techelevator.dao;

import com.techelevator.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcAccountDao implements AccountDao{

    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Account getAccountByAccountId(int accountId) {

        return null;
    }

    @Override
    public Account getAccountByUserId(int userId) {
        return null;
    }

    @Override
    public List<Integer> getPreferredGenres(int accountId) {
        return null;
    }

    @Override
    public List<Integer> getLikedMovies(int accountId) {
        return null;
    }

    @Override
    public List<Integer> getFavoriteMovies(int accountId) {
        return null;
    }

    @Override
    public List<Integer> getDislikedMovies(int accountId) {
        return null;
    }

    @Override
    public Account createAccount(int userId) {
        return null;
    }

    @Override
    public Account updateAccount(int accountId, int userId, List<Integer> preferredGenres, List<Integer> getLikedMovies, List<Integer> favoriteMovies, List<Integer> dislikedMovies) {
        return null;
    }

    @Override
    public boolean deleteAccount(int accountId) {
        return false;
    }

    private Account mapRowToAccount(SqlRowSet rowSet) {
        Account account = new Account();

        account.setAccountId(rowSet.getInt("account_id"));
        account.setUserId(rowSet.getInt("user_id"));
//        TODO: How to separate by comma
        account.setLikedMovies(rowSet.getString("liked_movies").split(","));
        account.setDislikedMovies(rowSet.getString("disliked_movies"));
        account.setFavoriteMovies(rowSet.getString("favorites"));
        account.setPreferredGenres(rowSet.getString("preferred_genre"));
//
        return account;
    }
}
