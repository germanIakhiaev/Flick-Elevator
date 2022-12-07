<template>
  <div class="home">
    <nav-bar />
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
  </div>
</template>

<script>
import NavBar from '../components/NavBar.vue';
export default {
  components: { NavBar },
  name: "home",

  created() {
    this.$store.commit("SET_MOVIES");
    this.$store.commit("SET_ACCOUNT");

      
  }
};
</script>
<style scoped>

</style>