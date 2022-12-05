package com.techelevator.controller;
import com.techelevator.model.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin
public class MovieController {

    //@Autowired
    //private MovieDao movieDao; TODO match this to DAOs ZL makes, then uncomment

    @GetMapping("/movie")
    public List<Movie> getAllMovies() {
        return movieDao.getMovies();
    }

    @PostMapping("/movie")
    public Movie postMovie() {
        return movieDao.postMovie();
    }

    @DeleteMapping("/movie/{movieId}")
    public void deleteMovie(@PathVariable("movieId") int movieId) {
        movieDao.deleteMovie(movieId);
    }






}
