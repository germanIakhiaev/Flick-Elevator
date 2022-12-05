package com.techelevator.dao;

import com.techelevator.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class JdbcMovieDao implements MovieDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public JdbcMovieDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie getMovieById(int movieId) {
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
}
