<template>
  <div class="home">
    <nav-bar />
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
  </div>
</template>

<script>
import NavBar from '../components/NavBar.vue';
//import MovieService from '../services/MovieService'
export default {
  components: { NavBar },
  name: "home",

  created() {
    this.$store.commit("SET_MOVIES");


    //  MovieService.getAllMovies().then(response => {
    //      this.$store.state.movies = response.data;
    //      let index = Math.floor(Math.random() * this.$store.state.movies.length);
    //     let movie = this.$store.state.movies[index];
    //     this.$store.state.randomMovie = movie;
    //  });
      
  }
};
</script>
