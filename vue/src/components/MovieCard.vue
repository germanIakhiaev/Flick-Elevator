<template>
  <div class="card movie-card">
    <div class="card-image">
      <img v-bind:src="'https://image.tmdb.org/t/p/original' + movie.poster_path">
    </div>
    <div class="card-content">
      <h3 class="movie-info is-size-3 has-text-weight-bold">{{movie.title}}</h3>
      <h3 class="movie-info is-size-5 has-text-weight-semi-bold">{{movie.genres}}</h3>  
      <h3 class="movie-info has-text-left" > <i class="fa-regular fa-calendar"></i> {{movie.release_date.substring(0,4)}}</h3>  
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
  background-color: rgb(172, 169, 221);
  /* background-color: hsl(0 0% 100% / 0.8); */
  color: #0F0C29;
  display: grid;
  grid-template-columns: 1fr 2fr;
  overflow: hidden;
  position: relative;
  width: 80vw;
  height: 40vw;
  margin: 80px auto; 
  border-radius: 10px;
  transition: all 0.4s;
  box-shadow: 0px 0px 120px -25px rgba(0,0,0, 0.5);
}

  .movie-card:hover{
    transform: scale(1.02);
    box-shadow: 0px 0px 80px -25px rgba(0,0,0, 0.5);
    transition: all 0.4s;
  }
.card-image img {
  height: auto;
  width: auto;
  border-radius: 5px;
}
.card-content {
  display: flex;
  flex-direction: column;
}

.movie-info {
  padding: 20px;
}


@media only screen and (max-width: 991px) {
  .movie-card {
    grid-template-columns: 1fr;
     height: 200vw;
  margin: 80px auto; 
  }

  h3 {
    padding: 0px;
  }

  .card-content {
    padding: 0px;
  }
}
</style>