<template>
  <div class="profile"> 
    <div class="profile-card">
    <div class="username">{{ user.username }}</div>

    <div class="genres">genres</div>
    </div>

      <div v-for="profileMovie in this.$store.state.likedMoviesArr" :key="profileMovie.id" class="card profileMovie-card">
    <div class="card-image">
      <img v-bind:src="'https://image.tmdb.org/t/p/original' + profileMovie.poster_path">
    </div>
    <div class="card-content">
      <h3 class="profileMovie-info is-size-3 has-text-weight-bold">{{profileMovie.title}}</h3>
      <h3 class="profileMovie-info is-size-5 has-text-weight-semi-bold">{{profileMovie.genres}}</h3>  
      <h3 class="profileMovie-info has-text-left">{{profileMovie.release_date}}</h3>  
      <h3 class="profileMovie-info has-text-left">{{ profileMovie.overview }}</h3>  

 <button
        class="favorite"
        @click="favoriteMovie(profileMovie.id)"
        v-if="!$store.state.account.favoriteMovies.includes(profileMovie.id)"
      >
        <i class="fa-solid fa-star"></i>&nbsp;Favorite Movie
      </button>
      <button
        class="unfavorite"
        @click="unfavoriteMovie(profileMovie.id)"
        v-if="$store.state.account.favoriteMovies.includes(profileMovie.id)"
      >
        <i class="fa-regular fa-star"></i>&nbsp;Unfavorite Movie
      </button>

      </div>
  </div>

  </div>
</template>

<script>
import accountService from '../services/AccountService.js'

export default {
  data() {
    return {
    userLikedMovies: [],
    likeCount: 0,
      dislikeCount: 0,
      favoriteCount: 0
    }
  },
  props: [ 'user', 'account' ],

  methods: {
    
    favoriteMovie(id) {
      this.favoriteCount++;
      this.$store.state.account.favoriteMovies += id + ",";
      this.$store.commit("SET_FAVORITES");
      
      if (this.favoriteCount >= 5) {
        accountService.updateAccount(
          this.$store.state.account.accountId,
          this.$store.state.account
        );
        this.favoriteCount = 0;
      }


    },
    unfavoriteMovie(id) {
      this.favoriteCount++;
      let favoriteMovieIds = this.$store.state.account.favoriteMovies.split(',');

      const index = favoriteMovieIds.indexOf(id);
      
      favoriteMovieIds = favoriteMovieIds.splice(index, 1);

      this.$store.state.account.favoriteMovies = favoriteMovieIds.toString();

      this.$store.commit("SET_FAVORITES");
      
      if (this.favoriteCount >= 5) {
        accountService.updateAccount(
          this.$store.state.account.accountId,
          this.$store.state.account
        );
        this.favoriteCount = 0;
      }


    }
  },
  
}
</script>

<style>
.profile-card {
  border: 1px transparent;
  border-radius: 5px;
  background-color: hsl(0 0% 100% / 0.8);
  color: #0F0C29;
  margin: 25px 0px;
}

.profileMovie-card {
  border: 1px transparent;
  border-radius: 5px;
  background-color: hsl(0 0% 100% / 0.8);
  color: #0F0C29;
  margin: 25px 0px;
  display: grid;
  grid-template-columns: 1fr 2fr;
  overflow: hidden;
}

.card-image img {
  height: 100%;
  width: 100%;
  border-radius: 5px;
}
.card-content {
  display: flex;
  flex-direction: column;
}

.profileMovie-info {
  padding: 20px;
}

@media only screen and (max-width: 991px) {
  .profileMovie-card {
    grid-template-columns: 1fr;
  }

  h3 {
    padding: 0px;
  }

  .card-content {
    padding: 0px;
  }
}


</style>