<template>
<div>
    <nav-bar />
    <movie-card />
    </div>
</template>

<script>
import MovieCard from '../components/MovieCard.vue'
import NavBar from '../components/NavBar.vue'
export default {
  name: 'discover',
  components: { NavBar, MovieCard },

}
</script>

<style>

</style>