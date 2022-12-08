<template> <!--this is a ripoff of MovieCard, but making the cards from API results -->
  <section class="card movie-card">
      <h2 class="movie-title">{{result.title}}</h2>
      <img class="movie-poster" src="moviepostersourcehere" alt="">
      <h3>{{convertedGenres}}</h3>  
      <h3 class="movie-year">{{result.release_date}}</h3>  
      <h3 class="card-content">{{result.overview}}</h3>
        <button @click="addMovieToDb">Add to Database</button>
  </section> 
</template>

<script>
export default {



    data() {
        return {
            movieToAdd: {
            
            },
        }
    },

    props:['result'],

    computed: {
      convertedGenres() {
          this.movie.genre_ids.forEach((genre) => {
              genre = this.$store.state.genres.genre;
          });
          return this.movie.genre_ids.join(" ");
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