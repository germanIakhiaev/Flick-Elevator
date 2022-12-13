<template>
  <section>
      <nav-bar></nav-bar>
    
    <section class="movie-card">
      <h3>such lorem wow ipsum</h3>
      <section>
          <div class="genre-selection">
                  <div class="genre-choice"><input type="checkbox" id="action" value="action" v-model="preferredGenres"><br><label for="action">Action</label></div>
                  <div class="genre-choice"><input type="checkbox" id="adventure" value="adventure" v-model="preferredGenres"><br><label for="adventure">Adventure</label></div>
                  <div class="genre-choice"><input type="checkbox" id="animation" value="animation" v-model="preferredGenres"><br><label for="animation">Animation</label></div>
                  <div class="genre-choice"><input type="checkbox" id="comedy" value="comedy" v-model="preferredGenres"><br><label for="comedy">Comedy</label></div>
                  <div class="genre-choice"><input type="checkbox" id="crime" value="crime" v-model="preferredGenres"><br><label for="crime">Crime</label></div>
                  <div class="genre-choice"><input type="checkbox" id="documentary" value="documentary" v-model="preferredGenres"><br><label for="documentary">Documentary</label></div>
              
                  <div class="genre-choice"><input type="checkbox" id="drama" value="drama" v-model="preferredGenres"><br><label for="drama">Drama</label></div>
                  <div class="genre-choice"><input type="checkbox" id="family" value="family" v-model="preferredGenres"><br><label for="family">Family</label></div>
                  <div class="genre-choice"><input type="checkbox" id="fantasy" value="fantasy" v-model="preferredGenres"><br><label for="fantasy">Fantasy</label></div>
                  <div class="genre-choice"><input type="checkbox" id="history" value="history" v-model="preferredGenres"><br><label for="history">History</label></div>
                  <div class="genre-choice"><input type="checkbox" id="horror" value="horror" v-model="preferredGenres"><br><label for="horror">Horror</label></div>
                  <div class="genre-choice"><input type="checkbox" id="music" value="music" v-model="preferredGenres"><br><label for="music">Music</label></div>
            
              
                  <div class="genre-choice"><input type="checkbox" id="mystery" value="mystery" v-model="preferredGenres"><br><label for="mystery">Mystery</label></div>
                  <div class="genre-choice"><input type="checkbox" id="romance" value="romance" v-model="preferredGenres"><br><label for="romance">Romance</label></div>
                  <div class="genre-choice"><input type="checkbox" id="sciFi" value="sciFi" v-model="preferredGenres"><br><label for="sciFi">Science Fiction</label></div>
                  <div class="genre-choice"><input type="checkbox" id="thriller" value="thriller" v-model="preferredGenres"><br><label for="thriller">Thriller</label></div>
                  <div class="genre-choice"><input type="checkbox" id="war" value="war" v-model="preferredGenres"><br><label for="war">War</label></div>
                  <div class="genre-choice"><input type="checkbox" id="western" value="western" v-model="preferredGenres"><br><label for="western">Western</label></div>
              
          </div>
      </section>
      <button v-if="showButton" @click="setPreferredGenres">Save Profile</button>
      </section>
  </section>
</template>

<script>
import NavBar from '../components/NavBar.vue'
import AccountService from '../services/AccountService.js'

export default {

components: {
    NavBar
},

data() {
    return {
        preferredGenres: []
    }
},

computed : {

    showButton() {
        return this.preferredGenres.length > 0;
    }

},

methods: {
    setPreferredGenres() {//conditional to make sure they select something?
        this.$store.state.account.preferredGenres = this.preferredGenres.join(" ");
        AccountService.updateAccount(this.$store.state.account.accountId, this.$store.state.account).then(() => {
            this.$router.push("/discover");
        });
        
    }
}
}
</script>

<style>
    .genre-selection {
        display: grid;
        grid-template-columns: 1fr 1fr 1fr;
    }
</style>