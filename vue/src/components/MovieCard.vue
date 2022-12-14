<template>
  <div class="card movie-card">   
    <div class="card-image">
      <img v-bind:src="'https://image.tmdb.org/t/p/original' + movie.poster_path">
    </div>
    <div class="card-content">
      <h3 class="movie-info is-size-2 has-text-weight-bold">{{movie.title}}</h3>
      <h3 class="movie-info is-size-4 has-text-weight-semi-bold genre py-5">{{movie.genres}}</h3>  
      <h3 class="movie-info is-size-4 has-text-left py-5" > <i class="fa-regular fa-calendar"></i> {{movie.release_date.substring(0,4)}}</h3>  
      <h3 class="movie-info is-size-5 has-text-left pb-6">{{ movie.overview }}</h3>  

<div class="inline-buttons">
       <button class="button is-focused is-danger" @click="dislikeMovie"><i class="fa-solid fa-thumbs-down"></i>&nbsp;Dislike</button>
    <button class="button is-focused is-success" @click="likeMovie"><i class="fa-solid fa-heart"></i>&nbsp;Like!</button>
</div>
    <button class="button is-focused is-info" @click="newRandomMovie"><i class="fa-solid fa-face-meh"></i>&nbsp;Skip</button>

      </div>
  </div>
</template>

<script>
// import MovieService from '../services/MovieService.js';
import accountService from '../services/AccountService.js'


export default {

  props: ['movie'],
  data() {
    return {
      likeCount: 0,
      dislikeCount: 0
    }
  },

  created() {
    if (this.$store.state.movies.length === 0) {
      this.$store.commit("SET_MOVIES");
    }
    // this.$store.commit("SET_LIKED_MOVIES");
    // this.$store.commit("SET_DISLIKED_MOVIES");
    // this.$store.commit("SET_FAVORITES");
    // this.$store.commit("SET_RANDOM_MOVIE");
    
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
      
      }
      //update database with new list every x likes, then wipe the count
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
.movie-card {
  border: 1px transparent;
  border-radius: 5px;
  background-color: hsl(0 0% 0% / 0.8);  /* background-color: hsl(0 0% 100% / 0.8); */
  color: #ffffff;
  display: grid;
  grid-template-columns: 1fr 2fr;
  overflow: hidden;
  position: relative;
  width: 80vw;
  height: 40vw;
  margin: 80px auto; 
  margin-bottom: 10px;
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
.genre {
  color: #FFFD82;
}

@media only screen and (max-width: 600px) {
  .movie-card {
  border: 1px transparent;
  border-radius: 5px;
  background-color: hsl(0 0% 100% / 0.5);
  color: #fcfcfc;
  margin: 25px 0px;
  display: grid;
  grid-template-columns: 1fr;
  overflow: hidden;
}
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