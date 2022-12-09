<template>
  <div class="profile"> 
    <div class="profile-icon">icon here</div>
    <div class="username">{{ user.username }}</div>
    <div class="full-name">full name</div>
    <div class="genres">genres</div>
    <div v-for="monkey in userLikedMovies" :key="monkey.id">{{monkey.title}}</div>
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
    this.generateLikedMoviesToDisplay();
  },

  methods: {
    // findMovieById(id) {
    //   this.$store.state.movies.forEach(movie => {
    //     const title = movie.title;
    //     console.log(title);
    //     console.log(id);
    //     if(movie.id === id) {
    //       console.log(movie.title);
    //       return movie;
    //     }
    //   });
    // },
    generateLikedMoviesToDisplay() {
      // let array = this.$store.state.account.likedMovies.split(',');
      // array.forEach(id => {
      //   this.userLikedMovies.push(this.findMovieById(id));
      // })
      let likedMovieIds = this.$store.state.account.likedMovies.split(',');
      this.userLikedMovies = this.$store.state.movies.filter(monkey => {
        console.log(monkey.id);
        console.log(monkey.title);
        console.log(likedMovieIds.includes(monkey.id.toString()));
        return likedMovieIds.includes(monkey.id.toString());
      })
    }
  }
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