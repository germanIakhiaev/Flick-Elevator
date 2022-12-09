<template>
  <div class="profile"> 
    <div class="profile-icon">icon here</div>
    <div class="username">{{ user.username }}</div>
    <div class="full-name">full name</div>
    <div class="genres">genres</div>
    <div v-for="profileMovie in this.$store.state.likedMoviesArr" :key="profileMovie.id">
      <h1>{{profileMovie.title}}</h1>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
    userLikedMovies: []
    }
  },
  props: [ 'user', 'account' ],

  created() {
     this.$store.commit("SET_LIKED_MOVIES");
  },

  
}
</script>

<style>
.profile {
  border: 1px transparent;
  border-radius: 5px;
  background-color: hsl(0 0% 100% / 0.5);
  color: #0F0C29;
  margin: 25px 0px;
}
</style>