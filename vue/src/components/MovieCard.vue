<template>
  <div class="movie-card">
      <h2 class="movie-title">{{this.movie.title}}</h2>
      <img class="movie-poster" src="moviepostersourcehere" alt="">
      <h3 class="movie-genre">movie genre</h3>  
      <h3 class="movie-year">{{this.movie.release_date}}</h3>  
      <h3 class="movie-director">movie director</h3>  
  </div>
</template>

<script>
// import MovieService from '../services/MovieService.js';

export default {
  data() {
    return {
      movie: {
        id: 0,
        title: '',
        poster_path: '',
        release_date: '',
      }
    }
  },

  // created() {
  //   MovieService.getAllMovies().then(response => {
  //     this.$store.commit("SET_MOVIES", response.data);
  //   }),

  //   this.getRandomMovie();
  // },


  // methods: {
  //   getRandomMovie() {
  //     let index = Math.floor(Math.random() * this.$store.state.movies.length);
  //     let movie = this.$store.state.movies[index];
  //     this.movie = movie;
  //   }
  // }

}
</script>

<style>
.movie-card {
  border: 1px solid black;
  border-radius: 10px;
}

</style>