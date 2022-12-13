package com.techelevator.dao;

import com.techelevator.model.Movie;
import org.junit.Before;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;

public class JdbcMovieDaoTests extends BaseDaoTests{

    protected static final Movie MOVIE_1 = new Movie(1, "title1", "action,comedy", LocalDate.of(2020, 01, 01), "overview1", 90.0, "www.poster1.com");
    protected static final Movie MOVIE_2 = new Movie(2, "title2", "romance,disaster", LocalDate.of(2019, 01, 01), "overview2", 80.0, "www.poster2.com");
    private static final Movie MOVIE_3 = new Movie(3, "title3", "horror,thriller", LocalDate.of(2018, 01, 01), "overview3", 70.0, "www.poster3.com");

    private JdbcMovieDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcMovieDao(jdbcTemplate);
    }

}
