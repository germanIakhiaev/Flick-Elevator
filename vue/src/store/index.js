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

    },

    genres: {//genre ids for TMDB admin query TODO swap these values for admin movie construction
      action: 28,
      adventure: 12,
      animation: 16,
      comedy: 35,
      crime: 80,
      documentary: 99,
      drama: 18,
      family: 10751,
      fantasy: 14,
      history: 36,
      horror: 27,
      music: 10402,
      mystery: 9648,
      romance: 10749,
      sciFi: 878,
      thriller: 53,
      war: 10752,
      western: 37
    }, 
    movies: [],
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
    },
    SET_ACCOUNT(state, userId) {
      AccountService.getUserAccount(userId).then(response => {
        state.account = response.data;
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
        state.randomMovie = state.movies[Math.floor(Math.random() * state.movies.length)];
        
      });
      
    },
    SET_RANDOM_MOVIE(state) {
      let index = Math.floor(Math.random() * state.movies.length);
      let movie = state.movies[index];
      state.randomMovie = movie;
    }
  }
  
})
