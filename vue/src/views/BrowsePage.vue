<template>
  <div>
    <nav-bar />
    <select name="criteria" v-model="criteria">
      <option value="">All Movies</option>
      <option value="liked">Liked Movies</option>
      <option value="favorite">Favorite Movies</option>
    </select>
    <select name="genre-select" id="genre-select" v-model="genre1">
      <option value="">Pick a Genre</option>
      <option value="action">Action</option>
      <option value="adventure">Adventure</option>
      <option value="animation">Animation</option>
      <option value="comedy">Comedy</option>
      <option value="crime">Crime</option>
      <option value="documentary">Documentary</option>
      <option value="drama">Drama</option>
      <option value="family">Family</option>
      <option value="fantasy">Fantasy</option>
      <option value="history">History</option>
      <option value="horror">Horror</option>
      <option value="music">Music</option>
      <option value="mystery">Mystery</option>
      <option value="romance">Romance</option>
      <option value="scifi">Science Fiction</option>
      <option value="thriller">Thriller</option>
      <option value="war">War</option>
      <option value="western">Western</option>
    </select>
    <select name="genre-select-2" id="genre-select-2" v-model="genre2">
      <option value="">Pick a Second Genre</option>
       <option value="action">Action</option>
      <option value="adventure">Adventure</option>
      <option value="animation">Animation</option>
      <option value="comedy">Comedy</option>
      <option value="crime">Crime</option>
      <option value="documentary">Documentary</option>
      <option value="drama">Drama</option>
      <option value="family">Family</option>
      <option value="fantasy">Fantasy</option>
      <option value="history">History</option>
      <option value="horror">Horror</option>
      <option value="music">Music</option>
      <option value="mystery">Mystery</option>
      <option value="romance">Romance</option>
      <option value="scifi">Science Fiction</option>
      <option value="thriller">Thriller</option>
      <option value="war">War</option>
      <option value="western">Western</option>
    </select>
     <browser-card v-bind:browse="browse" v-for="browse in moviesToBrowse" v-bind:key="browse.id"/> <!--TODO - alphabetize results? -->
    </div>
</template>

<script>
import BrowserCard from '../components/BrowserCard.vue'
import NavBar from '../components/NavBar.vue'
export default {
  name: 'browse',
  components: { NavBar, BrowserCard },

  data() {
    return {
      criteria: "",
      genre1: "", //modeled to dropdown menus
      genre2: ""
      
    }
  },

  computed: {

    moviesToBrowse() { //filtered based on drop-downs, replaces $store reference in template
      switch (this.criteria) {
        case "":
          return this.$store.state.movies.filter(movie => movie.genres.includes(this.genre1) && movie.genres.includes(this.genre2));
        case "liked":
          return this.$store.state.likedMoviesArr.filter(likedMovie => likedMovie.genres.includes(this.genre1) && likedMovie.genres.includes(this.genre2));
        case "favorite":
          return this.$store.state.favoriteMoviesArr.filter(favMovie => favMovie.genres.includes(this.genre1) && favMovie.genres.includes(this.genre2));
        default:
          return this.$store.state.movies;

      }

    }

  },
  
}
</script>

<style>

</style>