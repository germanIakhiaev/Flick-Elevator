<template>
  <section>
      <nav-bar></nav-bar>
      <form action=""><!--for searching TMDB -->
        <input type="text" placeholder="Search Movies">
        <button>Search</button>
      </form>
      <div><!--this appears to display search results - it loops-->
      <movie-card></movie-card>
      </div>
  </section>
</template>

<script>
import MovieCard from '..components.MovieCard.vue';
import NavBar from '..components.NavBar.vue';
export default {
    components: {
        MovieCard,
        NavBar
    }

}
</script>

<style>

</style>