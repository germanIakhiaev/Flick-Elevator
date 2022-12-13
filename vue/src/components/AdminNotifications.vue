<template>
  <section>
    <div class="admin-home-link">
      <router-link :to="{ name: 'admin' }">Back to Admin Home</router-link>
    </div>
    <div class="field" id="notif-housing">
      <table>
        <thead>
          <tr>
            <th>
              <!-- <label for="selectAllBox">
                    Select
                  <input type="checkbox" name="" id="selectAllBox" />
                </label> -->
            </th>
            <th>Username</th>
            <th>Role</th>
            <th>Request Admin</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="user in this.$store.state.allUsers" v-bind:key="user.id">
            <td>
              <input
                type="checkbox"
                v-bind:id="user.id"
                v-bind:value="user"
                v-model="selectedUsers"
              />
            </td>
            <td>{{ user.username }}</td>
            <td>{{ user.authorities[0].name }}</td>
            <td>{{ user.madeAdminRequest }}</td>
          </tr>
        </tbody>
      </table>
      <button @click.prevent="approveRequest()">Approve Selected</button>
      <button @click.prevent="rejectRequest()">Reject Selected</button>
    </div>
  </section>
</template>

<script>
import authService from "../services/AuthService.js";
export default {
  data() {
    return {
      selectedUsers: [],
    };
  },
  methods: {
    approveRequest() {
      for (let i = 0; i < this.$store.state.allUsers.length; i++) {
        for (let j = 0; j < this.selectedUsers.length; j++) {
          if (this.$store.state.allUsers[i] === this.selectedUsers[j]) {
            this.$store.state.allUsers[i].authorities[0].name = "ROLE_ADMIN";
            this.$store.state.allUsers[i].madeAdminRequest = false;
            authService.updateUser(
              this.$store.state.allUsers[i].id,
              this.$store.state.allUsers[i]
            );
          }
        }
      }
      this.selectedUsers = [];
    },
    rejectRequest() {
      for (let i = 0; i < this.$store.state.allUsers.length; i++) {
        for (let j = 0; j < this.selectedUsers.length; j++) {
          if (this.$store.state.allUsers[i] === this.selectedUsers[j]) {
            this.$store.state.allUsers[i].authorities[0].name = "ROLE_USER";
            this.$store.state.allUsers[i].madeAdminRequest = false;
            authService.updateUser(
              this.$store.state.allUsers[i].id,
              this.$store.state.allUsers[i]
            );
          }
        }
      }
      this.selectedUsers = [];
    },
  },
};
</script>

<style>
.button {
  color: #fff;
  background: #573b8a;
}

.admin-home-link {
  border: 1px transparent;
  border-radius: 5px;
  background-color: hsl(0 0% 100% / 0.8);
  color: #0f0c29;
  margin: 25px 0px;
  display: grid;
  overflow: hidden;
}

#notif-housing {
  border: 1px transparent;
  border-radius: 5px;
  background-color: hsl(0 0% 100% / 0.8);
  color: #0f0c29;
  margin: 25px 0px;
}
</style>