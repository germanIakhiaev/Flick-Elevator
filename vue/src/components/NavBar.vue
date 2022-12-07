<template>
      <nav class="navbar" role="navigation" aria-label="main navigation">
  <div class="navbar-brand">
    <router-link class="navbar-item" :to="{ name: 'discover' }">
      <img src="../assets/film.png" height="50"> Flick Elevator
    </router-link>

    <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
      <span aria-hidden="true"></span>
      <span aria-hidden="true"></span>
      <span aria-hidden="true"></span>
    </a>
  </div>

  <div class="navbar-menu">
    <div class="navbar-end">
      <router-link class="navbar-item" :to="{ name: 'discover' }">Discover</router-link>

      <router-link class="navbar-item" :to="{ name: 'browse' }">Browse</router-link>

      <div class="navbar-item has-dropdown is-hoverable">
        <a class="navbar-link">
          Profile
        </a>

        <div class="navbar-dropdown">
          <router-link class="navbar-item" :to="{ name: 'profile' }">Profile</router-link>
          <router-link class="navbar-item" :to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
        </div>

      </div>
    </div>
  </div>
</nav>
</template>

<script>
export default {

}
</script>

<style>
    nav {
      margin-bottom: 50px;
    }
</style>