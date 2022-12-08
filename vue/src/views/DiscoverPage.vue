<template>
<div>
    <nav-bar />
    <div>
    <movie-card :movie="this.$store.state.randomMovie"/>
    <button class="button is-focused is-success" @click="likeMovie">I like this!</button>
    <button class="button is-focused is-danger" @click="dislikeMovie">Don't show me this again</button>
    <button class="button is-focused is-info" @click="newRandomMovie">I don't feel either way about this</button>
    </div>
    </div>
</template>

<script>
import MovieCard from '../components/MovieCard.vue'
import NavBar from '../components/NavBar.vue'
import accountService from '../services/AccountService.js'
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
      this.$store.state.account.likedMovies += this.$store.state.randomMovie.id + ',';

      //update database with new list every x likes, then wipe the count
      accountService.updateAccount(this.$store.state.account.accountId, this.$store.state.account);
      
      this.$store.commit("SET_RANDOM_MOVIE");

    },

    dislikeMovie() {
      //add this random movie info to account list
      this.$store.state.account.dislikedMovies += this.$store.state.randomMovie.id + ',';
      
      //update database with new list every x likes, then wipe the count
      accountService.updateAccount(this.$store.state.account.accountId, this.$store.state.account);
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