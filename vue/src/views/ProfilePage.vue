<template>
  <div>
    <nav-bar />
    <profile-card />
  </div>
</template>

<script>
import NavBar from '../components/NavBar.vue'
import ProfileCard from '../components/ProfileCard.vue'
export default {
  components: { ProfileCard, NavBar },
  name: 'profile',

}
</script>

<style>

</style>