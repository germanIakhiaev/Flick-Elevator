<template>
   <div class="card browse-card">
    <div class="card-image">
      <img v-bind:src="'https://image.tmdb.org/t/p/original' + browse.poster_path">
    </div>
    <div class="card-content">
      <h2 class="browse-info is-size-3 has-text-weight-bold">{{browse.title}}</h2>
      <h3 class="browse-info is-size-5 has-text-weight-semi-bold">{{browse.genres}}</h3>  
      <h3 class="browse-info has-text-left">{{browse.release_date}}</h3>  
      <h3 class="browse-info has-text-left">{{ browse.overview }}</h3>  
      <button class="favorite button is-success" v-on:click.prevent="favorite(true)" v-if="!isFavorited"><i class="fa-solid fa-star"></i>&nbsp;Favorite Movie</button>
        <button class="unfavorite button is-danger" v-on:click.prevent="favorite(false)" v-if="isFavorited"><i class="fa-regular fa-star"></i>&nbsp;Unfavorite Movie</button>
      </div>
  </div>
</template>

<script>
export default {
  props: [
    'browse', 'account'
  ], 
  isFavorited: false,
   methods: {
     favorite(favoriteStatus) {
       this.isFavorited = favoriteStatus;
     }
   }
}
</script>

<style>
.browse-card {
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