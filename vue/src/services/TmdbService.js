import axios from 'axios';

const tmdb = axios.create({
    baseURL: process.env.TMDB_API_BASE_URL
  });

export default {

    /**This API is the broadest, simplest search available for movies. 
     * It appears to search all the string properties of the movie object for a match.
     * The farther you go into the search results, the poorer the matches become. 
     * Therefore, keep page=1 for now to only get best matches.
     * 
     * @param {String} queryString - a string to search by 
     * @returns an array of movie objects
     */
    searchMoviesByString(queryString) {
        queryString = queryString.replaceAll(" ", "%20");
        return tmdb.get(`search/movie?query={$queryString}&page=1&include_adult=false`);
    }

    /**
     * 
     * @param {number} genreId 
     * @returns 
     */
    getMoviesByGenre(genreId) {
        return tmdb.get(`discover/movie?with_genres=${genreId}&page=1`);
    }


}