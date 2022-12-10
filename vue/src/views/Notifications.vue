<template>
  <section>
      <nav-bar />
    <admin-notifications />
  </section>
</template>

<script>
import AdminNotifications from '../components/AdminNotifications.vue'
import NavBar from '../components/NavBar.vue'
export default {
    components: {
        AdminNotifications,
        NavBar
    }
}
</script>

<style>

</style>
AdminNotifications