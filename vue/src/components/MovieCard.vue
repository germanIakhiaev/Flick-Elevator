<template>
  <div class="movie-card">
      <h2 class="movie-title">movie title</h2>
      <img class="movie-poster" src="moviepostersourcehere" alt="">
      <h3 class="movie-genre">movie genre</h3>  
      <h3 class="movie-year">movie year</h3>  
      <h3 class="movie-director">movie director</h3>  
  </div>
</template>

<script>
import MovieService from '../services/MovieService';

export default {
  data() {
    return {
      movies: [],
      movie: {
        title: '',
        poster: '',
        genre: [],  
        year: '',
        director: ''
      }
    }
  },

  created() {
    MovieService.getAllMovies().then(response => {
      this.movies = response.data;
    })
  },

  methods: {
    getRandomMovie() {
      // this.movie.title = this.movies[0].title;
      // this.movie.poster = this.movies[0].poster;
      // this.movie.genre = this.movies[0].genre;
      // this.movie.year = this.movies[0].year;
      // this.movie.director = this.movies[0].director;

    }
  }
}
</script>

<style>
.movie-card {
  border: 1px solid black;
  border-radius: 10px;
}
</style>