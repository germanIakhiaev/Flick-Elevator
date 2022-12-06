package com.techelevator.dao;

import com.techelevator.model.Movie;
import org.springframework.dao.DataAccessException;
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
        String sql = "SELECT * FROM movies WHERE movie_id = ?;";

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
    public List<Movie> getAllMovies() {
        List<Movie> movieList = new ArrayList<>();
        String sql = "" +
                "SELECT * FROM movies;";

        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
            while (rowSet.next()) {
                Movie movie = mapRowToMovie(rowSet);
                movieList.add(movie);
            }
            return movieList;
        } catch (EmptyResultDataAccessException | NullPointerException e) {

        }
        return null;
    }

    @Override
    public Movie addMovie(Movie movieToAdd) {
        String sql = "" +
                "INSERT INTO movies (movie_id, title, release_date, genres_id, description, popularity, picture_path) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?) " +
                "RETURNING movie_id;";
        Movie addedMovie = jdbcTemplate.queryForObject(sql, Movie.class, movieToAdd.getId(),
                                                movieToAdd.getTitle(), movieToAdd.getRelease_date(),
                                                movieToAdd.getGenres(), movieToAdd.getOverview(), movieToAdd.getPopularity(),
                                                movieToAdd.getPoster_path());

        if (addedMovie.getId() == movieToAdd.getId()) {
            return addedMovie;
        } else {
            return null;
        }
    }

    @Override
    public Movie updateMovie(int id, String title, String[] genres, LocalDate release_date, String overview, double popularity, int runtime, String tagline, String poster_path) {
        return null;
    }

    @Override
    public boolean deleteMovie(int movieId) {
        String sql = "DELETE * FROM movies WHERE movie_id = ?;";

        try {
            return jdbcTemplate.update(sql, movieId) == 1;
        } catch (DataAccessException e) {

        }
        return false;
    }

    private Movie mapRowToMovie(SqlRowSet rowSet) {
        Movie movie = new Movie();

        movie.setId(rowSet.getInt("movie_id"));
        movie.setTitle(rowSet.getString("title"));
        movie.setRelease_date(rowSet.getDate("release_date").toLocalDate());
        movie.setGenres(rowSet.getString("genres_id").split(","));
        movie.setOverview(rowSet.getString("description"));
        movie.setPopularity(rowSet.getDouble("popularity"));
        movie.setPoster_path(rowSet.getString("picture_path"));

        return movie;
    }

}