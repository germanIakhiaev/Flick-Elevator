package com.techelevator.controller;

import com.techelevator.dao.AccountDao;
import com.techelevator.model.*;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AccountController {

    @Autowired
    private AccountDao accountDao;

    @GetMapping("/accounts/{userId}")
    public Account getUserAccount(@PathVariable("userId") int userId) {
        return accountDao.getAccountByUserId(userId);
    }

    @PutMapping("/accounts/{accountId}/genres")
    public void updatePreferredGenres(@PathVariable("accountId") int accountId, @RequestBody String genres) {
        accountDao.updatePreferredGenres(accountId, genres);
    }

    @PutMapping("/accounts/{accountId}")
    public void updateLikedMovies(@PathVariable("accountId") int accountId, @RequestBody Account account) {
        accountDao.updateAccount(accountId, account);
    }

    @PutMapping("/accounts/{accountId}/dislikes")
    public void updateDislikedMovies(@PathVariable("accountId") int accountId, @RequestBody String disLikedMovies) {
        accountDao.updateDislikedMovies(accountId, disLikedMovies);
    }

    @PutMapping("/accounts/{accountId}/favorites")
    public void updateFavorites(@PathVariable("accountId") int accountId, @RequestBody String favorites) {
        accountDao.updateFavorites(accountId, favorites);
    }

}
