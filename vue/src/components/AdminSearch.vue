<template>
  <section>
    <!--for searching TMDB -->
    <input type="text" placeholder="Search Movies" v-model="searchString" />
    <button @click="searchMovies">Search</button>
    <div v-for="result in results" :key="result.id">
       <h2 class="movie-title">{{result.title}}</h2>
      <img class="movie-poster" :src="'https://image.tmdb.org/t/p/w400' + result.poster_path" alt="">
      <h3>{{convertGenres(result)}}</h3>  
      <h3 class="movie-year">{{result.release_date}}</h3>  
      <h3 class="card-content">{{result.overview}}</h3>
      <button @click="addMovieToDb(result)">Add to Database</button>
      
      <!-- <admin-movie-card  ></admin-movie-card> -->
      
    </div>
  </section>
</template>

<script>
import TmdbService from "../services/TmdbService.js";
import MovieService from '../services/MovieService.js';

//import AdminMovieCard from "../components/MovieCard.vue";
export default {
  components: {
    //AdminMovieCard,
  },

  data() {
    return {
      searchString: "",

      page: 0,
      results: [],
      totalPages: 0,
      totalResults: 0,

      movieToAdd: {
            
            },
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
    },

    addMovieToDb(result) {
      const convertedGenres = this.convertGenres(result);
      
      this.movieToAdd = {
        id: result.id,
        title: result.title,
        genres: convertedGenres,
        release_date: result.release_date,
        overview: result.overview,
        popularity: result.popularity,
        poster_path: result.poster_path
      };
      MovieService.postMovie(this.movieToAdd).then(response => {
        if (response.status === 200) {
          this.movieToAdd = {};
          //do something
          const resultIndex = this.results.indexOf(result);
          this.results.splice(resultIndex, 1);
        }
      })

    },

    convertGenres(result) {
      let newGenre = result.genre_ids.map((genre) => {
           return this.$store.state.genres[genre];
          });
      return newGenre.join(" ");
    }

  }
};
</script>

<style>
</style>