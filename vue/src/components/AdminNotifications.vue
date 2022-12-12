<template>
  <section>
    <div class="field" id="notif-housing">
      <div>
        <router-link :to="{ name: 'admin' }">Back to Admin Home</router-link>
      </div>
      <form>
      <table>
          <thead>
              <tr>
                  <th>Username</th>
                  <th>Role</th>
                  <th>Request Admin</th>
                  <th>Approve/Reject Request</th>
              </tr>
          </thead>
          <tbody>
              <tr v-for="user in this.$store.state.allUsers" v-bind:key="user.id">
                  <td>{{user.username}}</td>
                  <td>{{user.authorities}}</td>
                  <td>{{user.madeAdminRequest}}</td>
                  <td><input type="checkbox"></td>
              </tr>
          </tbody>
      </table>
      <input type="submit" name="" id="">
      </form>
      
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