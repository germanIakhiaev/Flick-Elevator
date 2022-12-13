<template>
  <section>
      <nav-bar></nav-bar>
    
    <section class="movie-card">
      <h3>such lorem wow ipsum</h3>
      <section>
          <table>
              <tr>
                  <th><input type="checkbox" id="action" value="action" v-model="preferredGenres"><label for="action">Action</label></th>
                  <th><input type="checkbox" id="adventure" value="adventure" v-model="preferredGenres"><label for="adventure">Adventure</label></th>
                  <th><input type="checkbox" id="animation" value="animation" v-model="preferredGenres"><label for="animation">Animation</label></th>
                  <th><input type="checkbox" id="comedy" value="comedy" v-model="preferredGenres"><label for="comedy">Comedy</label></th>
                  <th><input type="checkbox" id="crime" value="crime" v-model="preferredGenres"><label for="crime">Crime</label></th>
                  <th><input type="checkbox" id="documentary" value="documentary" v-model="preferredGenres"><label for="documentary">Documentary</label></th>
              </tr>
              <tr>
                  <th><input type="checkbox" id="drama" value="drama" v-model="preferredGenres"><label for="drama">Drama</label></th>
                  <th><input type="checkbox" id="family" value="family" v-model="preferredGenres"><label for="family">Family</label></th>
                  <th><input type="checkbox" id="fantasy" value="fantasy" v-model="preferredGenres"><label for="fantasy">Fantasy</label></th>
                  <th><input type="checkbox" id="history" value="history" v-model="preferredGenres"><label for="history">History</label></th>
                  <th><input type="checkbox" id="horror" value="horror" v-model="preferredGenres"><label for="horror">Horror</label></th>
                  <th><input type="checkbox" id="music" value="music" v-model="preferredGenres"><label for="music">Music</label></th>
              </tr>
              <tr>
                  <th><input type="checkbox" id="mystery" value="mystery" v-model="preferredGenres"><label for="mystery">Mystery</label></th>
                  <th><input type="checkbox" id="romance" value="romance" v-model="preferredGenres"><label for="romance">Romance</label></th>
                  <th><input type="checkbox" id="sciFi" value="sciFi" v-model="preferredGenres"><label for="sciFi">Science Fiction</label></th>
                  <th><input type="checkbox" id="thriller" value="thriller" v-model="preferredGenres"><label for="thriller">Thriller</label></th>
                  <th><input type="checkbox" id="war" value="war" v-model="preferredGenres"><label for="war">War</label></th>
                  <th><input type="checkbox" id="western" value="western" v-model="preferredGenres"><label for="western">Western</label></th>
              </tr>
          </table>
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
            this.$store.commit("SET_ACCOUNT");
            this.$router.push("/discover");
        });
        
    }
}
}
</script>

<style>

</style>