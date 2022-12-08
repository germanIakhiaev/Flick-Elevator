<template> <!--this is a ripoff of MovieCard, but making the cards from API results -->
  <section class="movie-card">
      <h2 class="movie-title">{{movie.title}}</h2>
      <img class="movie-poster" src="moviepostersourcehere" alt="">
      <h3 class="movie-genre">{{/**computed variable for getting genre from store */}}</h3>  
      <h3 class="movie-year">{{movie.release_date}}</h3>  
      <h3 class="movie-overview">{{movie.overview}}</h3>
        <button @click="addMovieToDb">Add to Database</button>
  </section> 
</template>

<script>
export default {

    props:['movie'],

    data() {
        return {
            movieToAdd: {

            }
        }
    },

    methods: {
        
    addMovieToDb() {
      
      //create movie object from selected movie
      //call movieservice to post the movie
      //update for all users?
    },
    }

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