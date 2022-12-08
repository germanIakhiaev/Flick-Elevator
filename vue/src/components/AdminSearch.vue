<template>
  <section>
    <!--for searching TMDB -->
    <input type="text" placeholder="Search Movies" v-model="searchString" />
    <button @click="searchMovies">Search</button>
    <div>
      <!--this appears to display search results - it loops results-->
      <admin-movie-card v-for="movie in results" :key="movie.id" :movie="movie"></admin-movie-card>
      
    </div>
  </section>
</template>

<script>
import TmdbService from "../services/TmdbService.js";
//import MovieService from '../services/MovieService.js';

import AdminMovieCard from "../components/MovieCard.vue";
export default {
  components: {
    AdminMovieCard,
  },

  data() {
    return {
      searchString: "",

      page: 0,
      results: [],
      totalPages: 0,
      totalResults: 0,
    };
  },

  methods: {
    searchMovies() {
      TmdbService.searchMoviesByString(this.searchString).then((response) => {
        this.page = response.data.page; //see JSON example
        this.results = response.data.results;
        this.totalPages = response.data.total_pages;
        this.totalResults = response.data.total_results;
        console.log(this.results);
      });
    }

  }
};
</script>

<style>
</style>