<template>
<div>
    <nav-bar />
    <div>
    <movie-card :movie="this.$store.state.randomMovie"/>
    <button @click="likeMovie">I like this!</button>
    <button @click="dislikeMovie">Don't show me this again</button>
    <button @click="newRandomMovie">I don't feel either way about this</button>
    </div>
    </div>
</template>

<script>
import MovieCard from '../components/MovieCard.vue'
import NavBar from '../components/NavBar.vue'
export default {

  name: 'discover',
  components: { NavBar, MovieCard },
  data() {
    return {
      likeCount: 0,
      dislikeCount: 0
    }
  },
  methods: {

    likeMovie() {
      //add this random movie info to account list
      //update database with new list every x likes, then wipe the count
      this.$store.commit("SET_RANDOM_MOVIE");

    },

    dislikeMovie() {
      //add this random movie info to account list
      //update database with new list every x dislikes, then wipe count
      this.$store.commit("SET_RANDOM_MOVIE");

    },

    newRandomMovie() {
      this.$store.commit("SET_RANDOM_MOVIE");
    }
  }
}

</script>

<style>

</style>