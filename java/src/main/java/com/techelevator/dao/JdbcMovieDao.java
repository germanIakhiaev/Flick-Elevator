package com.techelevator.dao;

import com.techelevator.model.Movie;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMovieDao implements MovieDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public JdbcMovieDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie getMovieById(int movieId) {
        Movie movie;
        String sql = "SELECT * FROM movies WHERE movie_id = ?";

        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, movieId);
            if (rowSet.next()) {
                movie = mapRowToMovie(rowSet);
                return movie;
            }
        } catch (EmptyResultDataAccessException | NullPointerException e) {

        }
        return null;
    }

    @Override
    public Movie addMovie(int movieId) {
        return null;
    }

    @Override
    public Movie updateMovie(int id, String title, List<Integer> genres, LocalDate release_date, String overview, double popularity, int runtime, String tagline, String poster_path) {
        return null;
    }

    @Override
    public boolean deleteMovie(int movieId) {
        return false;
    }

    private Movie mapRowToMovie(SqlRowSet rowSet) {
        Movie movie = new Movie();

        movie.setId(rowSet.getInt("movie_id"));
        movie.setTitle(rowSet.getString("title"));
        movie.setRelease_date(rowSet.getDate("release_date").toLocalDate());
        // TODO: how to separate by comma
            //movie.setGenres(rowSet.getString("genres"));
        movie.setOverview(rowSet.getString("description"));
        movie.setPoster_path(rowSet.getString("picture_path"));

        return movie;
    }

}
