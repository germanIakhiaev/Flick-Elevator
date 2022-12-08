<template>
      <nav class="navbar is-transparent" aria-label="main navigation">
  <div class="navbar-brand">
    <router-link class="navbar-item" :to="{ name: 'discover' }">
      <img src="../assets/film.png" height="50"><p class="is-size-5 has-text-weight-bold" id="name">Flick Elevator</p>
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

        <div class="navbar-dropdown is-right">
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
    .navbar {
      background-color: hsl(0 0% 100% / 0.5);
      border-radius: 5px;
    }
    #name {
      padding-left: 5px;
    }
</style>