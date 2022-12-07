<template>
  <div class="card movie-card">
      <h2 class="card-content movie-title">{{movie.title}}</h2>
      <img v-bind:src="'https://image.tmdb.org/t/p/w400' + movie.poster_path">
      <h3 class="movie-genre">movie genre</h3>  
      <h3 class="card-content movie-year">{{movie.release_date}}</h3>  
      <h3 class="movie-popularity">{{ movie.popularity }}</h3>  
  </div>
</template>

<script>
// import MovieService from '../services/MovieService.js';

export default {
  // data() {
  //   return {
  //     movie: {
  //       id: 0,
  //       title: '',
  //       poster_path: '',
  //       release_date: '',
  //     }
  //   }
  // },
  props: ['movie']

    }
</script>

<style>
.movie-card {
  border: 1px solid black;
  border-radius: 10px;
  background-color: #BFBDC1;
  color: #0F0C29;
}

</style>