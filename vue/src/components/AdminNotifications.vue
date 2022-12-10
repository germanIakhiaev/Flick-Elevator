<template>
  <section>
    <div class="field" id="notif-housing">
      <div>
        <router-link :to="{ name: 'admin' }">Back to Admin Home</router-link>
      </div>
      
      
    </div>

    
  </section>
</template>

<script>
export default {};
</script>

<style>
.result-card {
  border: 1px transparent;
  border-radius: 5px;
  background-color: hsl(0 0% 100% / 0.8);
  color: #0f0c29;
  margin: 25px 0px;
  display: grid;
  grid-template-columns: 1fr 2fr;
  overflow: hidden;
}

.button {
  color: #fff;
  background: #573b8a;
}

.card-content {
  display: flex;
  flex-direction: column;
}

.movie-info {
  padding: 20px;
}
#notif-housing {
  border: 1px transparent;
  border-radius: 5px;
  background-color: hsl(0 0% 100% / 0.8);
  color: #0f0c29;
  margin: 25px 0px;
}
#search-term {
  width: 700px;
  max-width: 75vw;
}
#search-button {
  width: 700px;
  max-width: 75vw;
}
</style>