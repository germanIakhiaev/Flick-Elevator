<template>
  <div>
    <nav-bar />
     <browser-card v-bind:browse="browse" v-for="browse in $store.state.movies" v-bind:key="browse.id"/>
    </div>
</template>

<script>
import BrowserCard from '../components/BrowserCard.vue'
import NavBar from '../components/NavBar.vue'
export default {
  name: 'browse',
  components: { NavBar, BrowserCard },
  
}
</script>

<style>

</style>