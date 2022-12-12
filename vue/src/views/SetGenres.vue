<template>
  <section>
      <nav-bar></nav-bar>

      <h3>such lorem wow ipsum</h3>
      <section>
          <table>
              <tr>
                  <th><input type="checkbox" name="" id="" value="action" v-model="preferredGenres"><label for="">Action</label></th>
                  <th><input type="checkbox" name="" id="" value="adventure" v-model="preferredGenres"><label for="">Adventure</label></th>
                  <th><input type="checkbox" name="" id="" value="animation" v-model="preferredGenres"><label for="">Animation</label></th>
                  <th><input type="checkbox" name="" id="" value="comedy" v-model="preferredGenres"><label for="">Comedy</label></th>
                  <th><input type="checkbox" name="" id="" value="crime" v-model="preferredGenres"><label for="">Crime</label></th>
                  <th><input type="checkbox" name="" id="" value="documentary" v-model="preferredGenres"><label for="">Documentary</label></th>
              </tr>
              <tr>
                  <th><input type="checkbox" name="" id="" value="drama" v-model="preferredGenres"><label for="">Drama</label></th>
                  <th><input type="checkbox" name="" id="" value="family" v-model="preferredGenres"><label for="">Family</label></th>
                  <th><input type="checkbox" name="" id="" value="fantasy" v-model="preferredGenres"><label for="">Fantasy</label></th>
                  <th><input type="checkbox" name="" id="" value="history" v-model="preferredGenres"><label for="">History</label></th>
                  <th><input type="checkbox" name="" id="" value="horror" v-model="preferredGenres"><label for="">Horror</label></th>
                  <th><input type="checkbox" name="" id="" value="music" v-model="preferredGenres"><label for="">Music</label></th>
              </tr>
              <tr>
                  <th><input type="checkbox" name="" id="" value="mystery" v-model="preferredGenres"><label for="">Mystery</label></th>
                  <th><input type="checkbox" name="" id="" value="romance" v-model="preferredGenres"><label for="">Romance</label></th>
                  <th><input type="checkbox" name="" id="" value="sciFi" v-model="preferredGenres"><label for="">Science Fiction</label></th>
                  <th><input type="checkbox" name="" id="" value="thriller" v-model="preferredGenres"><label for="">Thriller</label></th>
                  <th><input type="checkbox" name="" id="" value="war" v-model="preferredGenres"><label for="">War</label></th>
                  <th><input type="checkbox" name="" id="" value="western" v-model="preferredGenres"><label for="">Western</label></th>
              </tr>
          </table>
      </section>
  </section>
</template>

<script>
import NavBar from '../components/NavBar.vue'
import accountService from '../services/AccountService.js'

export default {

components: {
    NavBar
},

data() {
    return {
        preferredGenres: []
    }
}
}
</script>

<style>

</style>