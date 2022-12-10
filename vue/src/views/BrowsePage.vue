<template>
  <div>
    <nav-bar />
    <select name="criteria">
      <option value="">All Movies</option>
      <option value="">Liked Movies</option>
      <option value="">Favorite Movies</option>
    </select>
    <select name="genre-select" id="genre-select">
      <option value="">Pick a Genre</option>
      <option value="">Action</option>
      <option value="">Adventure</option>
      <option value="">Animation</option>
      <option value="">Comedy</option>
      <option value="">Crime</option>
      <option value="">Documentary</option>
      <option value="">Drama</option>
      <option value="">Family</option>
      <option value="">Fantasy</option>
      <option value="">History</option>
      <option value="">Horror</option>
      <option value="">Music</option>
      <option value="">Mystery</option>
      <option value="">Romance</option>
      <option value="">Science Fiction</option>
      <option value="">Thriller</option>
      <option value="">War</option>
      <option value="">Western</option>
    </select>
    <select name="genre-select-2" id="genre-select-2">
      <option value="">Pick a Second Genre</option>
      <option value="">Action</option>
      <option value="">Adventure</option>
      <option value="">Animation</option>
      <option value="">Comedy</option>
      <option value="">Crime</option>
      <option value="">Documentary</option>
      <option value="">Drama</option>
      <option value="">Family</option>
      <option value="">Fantasy</option>
      <option value="">History</option>
      <option value="">Horror</option>
      <option value="">Music</option>
      <option value="">Mystery</option>
      <option value="">Romance</option>
      <option value="">Science Fiction</option>
      <option value="">Thriller</option>
      <option value="">War</option>
      <option value="">Western</option>
    </select>
     <browser-card v-bind:browse="browse" v-for="browse in $store.state.movies" v-bind:key="browse.id"/> <!--TODO - alphabetize results? -->
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
      moviesToBrowse: [], //filtered based on drop-downs, replaces $store reference in template
      genre1: "", //modeled to dropdown menus
      genre2: ""
      
    }
  },

  methods: {

    setMoviesToBrowse(criteria) {
      //join genre1 and genre2 as string or array

      //filter $store movies based on criteria selection
        //further filter by genre selection
      
      //assign final array to moviesToBrowse
      return criteria;
    }

  }
  
}
</script>

<style>

</style>