import axios from 'axios';

export default {

    getUserAccount(userId) {
        return axios.get(`/accounts/${userId}`);
    },
//do rest of methods
    updatePreferredGenres(accountId, genres) {
        return axios.put(`/accounts/${accountId}/genres`, genres);
    },

    updateLikedMovies(accountId, likedMovies) {
        return axios.put(`/accounts/${accountId}/likes`, likedMovies);
    },

    updateDislikedMovies(accountId, dislikedMovies) {
        return axios.put(`/accounts/${accountId}/dislikes`, dislikedMovies);
    },

    updateFavorites(accountId, favorites) {
        return axios.put(`/accounts/${accountId}/favorites`, favorites);
    }

}