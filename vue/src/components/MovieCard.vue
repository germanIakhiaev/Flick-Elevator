<template>
  <div class="card movie-card">
    <div class="card-image">
      <img v-bind:src="'https://image.tmdb.org/t/p/w500' + movie.poster_path">
    </div>
    <div class="card-content">
      <h2 class="movie-info is-size-3 has-text-weight-bold">{{movie.title}}</h2>
      <h3 class="movie-info is-size-5 has-text-weight-semi-bold">{{movie.genres}}</h3>  
      <h3 class="movie-info has-text-left">{{movie.release_date}}</h3>  
      <h3 class="movie-info has-text-left">{{ movie.overview }}</h3>  
      </div>
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
  border: 1px transparent;
  border-radius: 5px;
  background-color: hsl(0 0% 100% / 0.5);
  background-image: url("C:/Users/Student/Downloads/theater.webp"); /* ../src/img/theater.webp */
  color: #f1edf3;
  margin: 25px 0px;
  display: grid;
  grid-template-columns: 1fr 2fr;
  overflow: hidden;
}


.card-image img {
  height: 100%;
  width: 100%;
  border-radius: 5px;
}
.card-content {
  display: flex;
  flex-direction: column;
}

.movie-info {
  padding: 20px;
}
@media only screen and (max-width: 600px) {
  .movie-card {
  border: 1px transparent;
  border-radius: 5px;
  background-color: hsl(0 0% 100% / 0.5);
  color: #fcfcfc;
  margin: 25px 0px;
  display: grid;
  grid-template-columns: 1fr;
  overflow: hidden;
}
}


</style>