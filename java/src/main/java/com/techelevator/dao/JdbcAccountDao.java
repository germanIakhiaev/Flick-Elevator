package com.techelevator.dao;

import com.techelevator.model.Account;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        Account account;
        String sql = "" +
                "SELECT * FROM accounts " +
                "WHERE account_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, accountId);
        try {
            if (rowSet.next()) {
                account = mapRowToAccount(rowSet);
                return account;
            }
            return null;
        } catch (EmptyResultDataAccessException | NullPointerException e) {

        }
        return null;
    }

    @Override
    public Account getAccountByUserId(int userId) {
        Account account;
        String sql = "" +
                "SELECT * FROM accounts " +
                "WHERE user_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        try {
            if (rowSet.next()) {
                account = mapRowToAccount(rowSet);
                return account;
            }
            return null;
        } catch (EmptyResultDataAccessException | NullPointerException e) {

        }
        return null;
    }

    @Override
    public String getPreferredGenres(int accountId) {
        String sql = "" +
                "SELECT preferred_genre " +
                "FROM accounts " +
                "WHERE account_id = ?;";
        try {
            String genres = jdbcTemplate.queryForObject(sql, String.class, accountId);
            return genres;
        } catch (EmptyResultDataAccessException | NullPointerException e) {

        }
        return null;
    }

    @Override
    public String getLikedMovies(int accountId) {
        String sql = "" +
                "SELECT liked_movies " +
                "FROM accounts " +
                "WHERE account_id = ?;";
        try {
            String liked = jdbcTemplate.queryForObject(sql, String.class, accountId);
            return liked;
        } catch (EmptyResultDataAccessException | NullPointerException e) {

        }
        return null;
    }

    @Override
    public String getFavoriteMovies(int accountId) {
        String sql = "" +
                "SELECT favorites " +
                "FROM accounts " +
                "WHERE account_id = ?;";
        try {
            String favorites = jdbcTemplate.queryForObject(sql, String.class, accountId);
            return favorites;
        } catch (EmptyResultDataAccessException | NullPointerException e) {

        }
        return null;
    }

    @Override
    public String getDislikedMovies(int accountId) {
        String sql = "" +
                "SELECT disliked_movies " +
                "FROM accounts " +
                "WHERE account_id = ?;";
        try {
            String disliked = jdbcTemplate.queryForObject(sql, String.class, accountId);
            return disliked;
        } catch (EmptyResultDataAccessException | NullPointerException e) {

        }
        return null;
    }

    @Override
    public Account createAccount(int userId) {
        String sql = "" +
                "INSERT INTO accounts (user_id, liked_movies, disliked_movies, favorites, preferred_genre) " +
                "VALUES (?, ?, ?, ?, ?) " +
                "RETURNING account_id;";
        Account newAccount = jdbcTemplate.queryForObject(sql, Account.class, userId, "", "", "", "");
        if (newAccount.getUserId() == userId) {
            return newAccount;
        } else {
            return null;
        }
    }

    @Override
    public Account updateLikedMovies(int accountId, String updatedLikes) {
        String sql = "" +
                "UPDATE accounts " +
                "SET liked_movies = ? " +
                "WHERE account_id = ?;";
        try {
            jdbcTemplate.update(sql, updatedLikes, accountId);
            return getAccountByAccountId(accountId);
        } catch (EmptyResultDataAccessException | NullPointerException e) {

        }
        return null;
    }

    @Override
    public Account updateDislikedMovies(int accountId, String updatedDislikes) {
        String sql = "" +
                "UPDATE accounts " +
                "SET disliked_movies = ? " +
                "WHERE account_id = ?;";
        try {
            jdbcTemplate.update(sql, updatedDislikes, accountId);
            return getAccountByAccountId(accountId);
        } catch (EmptyResultDataAccessException | NullPointerException e) {

        }
        return null;
    }

    @Override
    public Account updateFavorites(int accountId, String updatedFavorites) {
        String sql = "" +
                "UPDATE accounts " +
                "SET favorites = ? " +
                "WHERE account_id = ?;";
        try {
            jdbcTemplate.update(sql, updatedFavorites, accountId);
            return getAccountByAccountId(accountId);
        } catch (EmptyResultDataAccessException | NullPointerException e) {

        }
        return null;
    }

    @Override
    public Account preferredGenres(int accountId, String updatedGenres) {
        String sql = "" +
                "UPDATE accounts " +
                "SET preferred_genre = ? " +
                "WHERE account_id = ?;";
        try {
            jdbcTemplate.update(sql, updatedGenres, accountId);
            return getAccountByAccountId(accountId);
        } catch (EmptyResultDataAccessException | NullPointerException e) {

        }
        return null;
    }

    @Override
    public boolean deleteAccount(int accountId) {
        String sql = "" +
                "DELETE * " +
                "FROM accounts " +
                "WHERE account_id = ?;";

        try {
            return jdbcTemplate.update(sql, accountId) == 1;
        } catch (DataAccessException e) {

        }
        return false;
    }

    private Account mapRowToAccount(SqlRowSet rowSet) {
        Account account = new Account();

        account.setAccountId(rowSet.getInt("account_id"));
        account.setUserId(rowSet.getInt("user_id"));
        account.setLikedMovies(rowSet.getString("liked_movies"));
        account.setDislikedMovies(rowSet.getString("disliked_movies"));
        account.setFavoriteMovies(rowSet.getString("favorites"));
        account.setPreferredGenres(rowSet.getString("preferred_genre"));

        return account;
    }
}
