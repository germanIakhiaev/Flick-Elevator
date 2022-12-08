<template>
  <div class="profile"> 
    <div class="profile-icon">icon here</div>
    <div class="username">{{ user.username }}</div>
    <div class="full-name">full name</div>
    <div class="genres">genres</div>
  </div>
</template>

<script>
export default {
  props: [ 'user', 'account' ]
}
</script>

<style>
.profile {
  border: 1px transparent;
  border-radius: 5px;
  background-color: hsl(0 0% 100% / 0.5);
  color: #0F0C29;
  margin: 25px 0px;
}
</style>