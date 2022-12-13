<template>
<div>
    <nav-bar />
    <div>
    <movie-card :movie="this.$store.state.randomMovie"/>
    <button class="button is-focused is-danger" @click="dislikeMovie"><i class="fa-solid fa-thumbs-down"></i>&nbsp;Dislike</button>
    <button class="button is-focused is-success" @click="likeMovie"><i class="fa-solid fa-heart"></i>&nbsp;Like!</button>
    <button class="button is-focused is-info" @click="newRandomMovie"><i class="fa-solid fa-face-meh"></i>&nbsp;Skip</button>
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

  created() {
    this.$store.commit("SET_LIKED_MOVIES");
    this.$store.commit("SET_DISLIKED_MOVIES");
    this.$store.commit("SET_FAVORITES");
    this.$store.commit("SET_RANDOM_MOVIE");
    
  },
  destroyed() {
    //update db with unadded responses
      accountService.updateAccount(this.$store.state.account.accountId, this.$store.state.account);
      this.likeCount = 0;
      this.dislikeCount = 0;
    //update front-end movie arrays
  },
    
  methods: {

    likeMovie() {
      if (!this.$store.state.account.likedMovies.includes(this.$store.state.randomMovie.id)) {
      this.likeCount++;
      //add this random movie info to account list
      this.$store.state.account.likedMovies += this.$store.state.randomMovie.id + ',';
      this.$store.commit("SET_LIKED_MOVIES");
      //TODO update likedMovieArr
      }
      //update database with new list every x likes, then wipe the count
      //TODO also update db when leaving view
      if (this.likeCount >= 5) {
      accountService.updateAccount(this.$store.state.account.accountId, this.$store.state.account);
      this.likeCount = 0;
      }
      this.$store.commit("SET_RANDOM_MOVIE");

    },

    dislikeMovie() {
      this.dislikeCount++
      //add this random movie info to account list
      this.$store.state.account.dislikedMovies += this.$store.state.randomMovie.id + ',';
      this.$store.commit("SET_DISLIKED_MOVIES");
      //TODO update dislikedMovieArr

      //update database with new list every x likes, then wipe the count
      if (this.dislikeCount >= 5) {
      accountService.updateAccount(this.$store.state.account.accountId, this.$store.state.account);
      this.dislikeCount = 0;
      }
      this.$store.commit("SET_RANDOM_MOVIE");

    },

    newRandomMovie() {
      this.$store.commit("SET_RANDOM_MOVIE");
      //TODO check against time-out
    }
  }
}

</script>

<style>

button:hover{
  
    transform: scale(1.02);
    box-shadow: 0px 0px 80px -25px rgba(0,0,0, 0.5);
    transition: all 0.4s;
  }
</style>