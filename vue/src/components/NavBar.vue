<template>
  <div class="navbar">
      <router-link :to="{ name: 'browse' }">Browse</router-link>
      <router-link :to="{ name: 'discover' }">Discover</router-link>
      <router-link :to="{ name: 'profile' }">Profile</router-link>
  </div>
</template>

<script>
export default {

}
</script>

<style>
    .navbar {
        display: flex;
        justify-content: space-evenly;
    }
</style>