import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
import MovieService from '../services/MovieService'
import AccountService from '../services/AccountService'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    account: {
      accountId: 0,
      userId: 0,
      preferredGenres: "",
      likedMovies: "",
      favoriteMovies: "",
      dislikedMovies: ""
    },

    genres: {//genre ids for TMDB admin query TODO swap these values for admin movie construction
      28: "action",
      12: "adventure",
      16: "animation",
      35: "comedy",
      80: "crime",
      99: "documentary",
      18: "drama",
      10751: "family",
      14: "fantasy",
      36: "history",
      27: "horror",
      10402: "music",
      9648: "mystery",
      10749: "romance",
      878: "sciFi",
      53: "thriller",
      10752: "war",
      37: "western"
    }, 
    movies: [],
    likedMoviesArr: [],
    dislikedMoviesArr: [],
    favoriteMoviesArr: [],
    randomMovie: {}
      
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
      this.commit("SET_MOVIES");
      this.commit("SET_ACCOUNT");


    },
    SET_ACCOUNT(state) {
      AccountService.getUserAccount(state.user.id).then(response => {
        state.account.accountId = response.data.accountId;
        state.account.userId = response.data.userId;
        state.account.preferredGenres = response.data.preferredGenres;
        state.account.likedMovies = response.data.likedMovies;
        state.account.favoriteMovies = response.data.favoriteMovies;
        state.account.dislikedMovies = response.data.dislikedMovies;
        this.commit("SET_LIKED_MOVIES");
        this.commit("SET_DISLIKED_MOVIES");
        this.commit("SET_FAVORITES");
        this.commit("SET_RANDOM_MOVIE");
      });
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    SET_MOVIES(state) {
      MovieService.getAllMovies().then(response => {
        state.movies = response.data;
        
      });
      
    },
    SET_LIKED_MOVIES(state) {
      const likedMovieIds = state.account.likedMovies.split(',');

      state.movies.forEach(likedMovie => {
        if (likedMovieIds.includes(likedMovie.id.toString())) {
          state.likedMoviesArr.push(likedMovie);
        }
      });
    },
    SET_DISLIKED_MOVIES(state) {
      const dislikedMovieIds = state.account.dislikedMovies.split(',');

      state.movies.forEach(dislikedMovie => {
        if (dislikedMovieIds.includes(dislikedMovie.id.toString())) {
          state.dislikedMoviesArr.push(dislikedMovie);
        }
      });
    },
    SET_FAVORITES(state) {
      const favoriteMovieIds = state.account.favoriteMovies.split(',');

      state.movies.forEach(favoriteMovie => {
        if (favoriteMovieIds.includes(favoriteMovie.id.toString())) {
          state.favoriteMoviesArr.push(favoriteMovie);
        }
      });
    },

    SET_RANDOM_MOVIE(state) {
      const dislikedMovieIds = state.account.dislikedMovies.split(',');
      let isValid = true;
      let index = 0;
      let movie;
      do {
        index = Math.floor(Math.random() * state.movies.length);
        movie = state.movies[index];

        if (dislikedMovieIds.includes(movie.id.toString())) { //or not interested wait time
          isValid = false;
        }

      } while (isValid == false);
      state.randomMovie = movie;
      
    }
  }
  
})
