import axios from 'axios';

export default {

  getAllUsers() {
    return axios.get('/user');
},

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  }

}
