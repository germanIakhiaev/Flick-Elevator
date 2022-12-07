import axios from 'axios';

export default {

    getUserAccount(userId) {
        return axios.get(`/account/${userId}`);
    },


}