<template>
<div>
  <div class="browse-card">
    <div class="card-image">
      <img
        v-bind:src="'https://image.tmdb.org/t/p/original' + browse.poster_path"
      />
    </div>
    <div class="card-content">
      <h2 class="browse-info is-size-2 has-text-weight-bold">
        {{ browse.title }}
      </h2>
      <h3 class="browse-info is-size-4 has-text-weight-semi-bold genre">
        {{ browse.genres }}
      </h3>
      <h3 class="browse-info has-text-left is-size-4"><i class="fa-regular fa-calendar"></i> {{ browse.release_date.substring(0,4) }}</h3>
      <h3 class="browse-info has-text-left is-size-4">{{ browse.overview }}</h3>
      
      <button class="button is-focused is-success" @click="likeMovie(browse.id)">
        <i class="fa-solid fa-heart"></i>&nbsp;I like this!
      </button>
      <button class="button is-focused is-danger" @click="dislikeMovie(browse.id)">
        <i class="fa-solid fa-thumbs-down"></i>&nbsp;Don't show me this again
      </button>

      <button
        class="favorite"
        @click="favoriteMovie(browse.id)"
        v-if="!$store.state.account.favoriteMovies.includes(browse.id)"
      >
        <i class="fa-solid fa-star"></i>&nbsp;Favorite Movie
      </button>
      <button
        class="unfavorite is-danger"
        @click="unfavoriteMovie(browse.id)"
        v-if="$store.state.account.favoriteMovies.includes(browse.id)"
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
  props: {
    browse: {
      type: Object,
    }
  },
data() {
    return {
      likeCount: 0,
      dislikeCount: 0,
      favoriteCount: 0
    }
  },

  methods: {
     likeMovie(id) {
      if (!this.$store.state.account.likedMovies.includes(id)) {
      this.likeCount++;
      //add this random movie info to account list
      this.$store.state.account.likedMovies += id + ',';
      this.$store.commit("SET_LIKED_MOVIES");
      
      }
      //update database with new list every x likes, then wipe the count
      if (this.likeCount >= 5) {
      accountService.updateAccount(this.$store.state.account.accountId, this.$store.state.account);
      this.likeCount = 0;
      }
      this.$store.commit("SET_RANDOM_MOVIE");

    },

    dislikeMovie(id) {
      this.dislikeCount++
      //add this random movie info to account list
      this.$store.state.account.dislikedMovies += id + ',';
      this.$store.commit("SET_DISLIKED_MOVIES");
      

      //update database with new list every x likes, then wipe the count
      if (this.dislikeCount >= 5) {
      accountService.updateAccount(this.$store.state.account.accountId, this.$store.state.account);
      this.dislikeCount = 0;
      }
      this.$store.commit("SET_RANDOM_MOVIE");

    },

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
};
</script>

<style>

.brow-card:hover{
    transform: scale(1.02);
    box-shadow: 0px 0px 80px -25px rgba(0,0,0, 0.5);
    transition: all 0.4s;
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
.browse-card {
  border: 1px transparent;
  border-radius: 5px;
  background-color: hsl(0 0% 0% / 0.8); 
  color: #ffffff;
  margin: 25px 0px;
  display: grid;
  grid-template-columns: 1fr 2fr;
  overflow: hidden;
}

.browse-info {
  padding: 20px;
}

@media only screen and (max-width: 991px) {
  .browse-card {
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