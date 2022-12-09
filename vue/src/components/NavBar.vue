<template>
  <nav class="navbar is-transparent" aria-label="main navigation">
    <div class="navbar-brand">
      <router-link class="navbar-item" :to="{ name: 'discover' }">
        <img src="../assets/film.png" height="50" />
        <p class="is-size-5 has-text-weight-bold" id="name">Flick Elevator</p>
      </router-link>

      <a
        role="button"
        class="navbar-burger"
        aria-label="menu"
        aria-expanded="false"
        data-target="navbarBasicExample"
        @click="toggleIsActive"
      >
        <span aria-hidden="true"></span>
        <span aria-hidden="true"></span>
        <span aria-hidden="true"></span>
      </a>
    </div>

    <div class="navbar-menu" :class="{ 'is-active': isActive }">
      <div class="navbar-end">
        <router-link class="navbar-item" :to="{ name: 'discover' }"
          >Discover</router-link
        >

        <router-link class="navbar-item" :to="{ name: 'browse' }"
          >Browse</router-link
        >

        <router-link class="navbar-item" :to="{ name: 'profile' }"
          >Profile</router-link
        >
        <router-link
          class="navbar-item"
          :to="{ name: 'logout' }"
          v-if="$store.state.token != ''"
          >Logout</router-link
        >
      </div>
    </div>
  </nav>
</template>

<script>
export default {
  data() {
    return {
      isActive: false,
    };
  },
  methods: {
    toggleIsActive() {
      this.isActive = !this.isActive;
    },
  },
};
</script>

<style>
.navbar {
  background-color: hsl(0 0% 100% / 0.8);
  border-radius: 5px;
}
.navbar-menu.is-active {
  background-color: hsl(0 0% 100% / 0.8);
  border-radius: 5px;
}
#name {
  padding-left: 5px;
}
</style>