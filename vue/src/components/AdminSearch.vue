<template>
  <section>
    <!--for searching TMDB -->
    <form class="field" id="search-card">
      <label for="search-term" class="label">Search By Keyword</label>
      <div class="control">
    <input id="search-term" class="input" type="text" placeholder="Search Movies" v-model="searchString" />
    </div>
    <button id="search-button" @click="searchMovies">Search</button>
    </form>

    <div class="result-card" v-for="result in results" :key="result.id">
      <div class="card-image">
        <img
          class="movie-poster"
          :src="'https://image.tmdb.org/t/p/w400' + result.poster_path"
          alt=""
        />
      </div>
      <div class="movie-info card-content">
        <h2 class="movie-info is-size-3 has-text-weight-bold">
          {{ result.title }}
        </h2>
        <h3 class="movie-info is-size-5">{{ convertGenres(result) }}</h3>
        <h3 class="movie-info has-text-left">{{ result.release_date }}</h3>
        <h3 class="movie-info has-text-left">{{ result.overview }}</h3>
        <button class="movie-info button" @click="addMovieToDb(result)">
          <i class="fa-solid fa-plus"></i>&nbsp;Add to Database
        </button>
      </div>
      <!-- <admin-movie-card  ></admin-movie-card> -->
    </div>
  </section>
</template>

<script>
import TmdbService from "../services/TmdbService.js";
import MovieService from "../services/MovieService.js";

//import AdminMovieCard from "../components/MovieCard.vue";
export default {
  components: {
    //AdminMovieCard,
  },

  data() {
    return {
      searchString: "",

      page: 0,
      results: [],
      totalPages: 0,
      totalResults: 0,

      movieToAdd: {},
    };
  },

  methods: {
    searchMovies() {
      TmdbService.searchMoviesByString(this.searchString).then((response) => {
        this.page = response.data.page; //see JSON example
        this.results = response.data.results;
        this.totalPages = response.data.total_pages;
        this.totalResults = response.data.total_results;
        console.log(this.results);
      });
    },

    addMovieToDb(result) {
      const convertedGenres = this.convertGenres(result);

      this.movieToAdd = {
        id: result.id,
        title: result.title,
        genres: convertedGenres,
        release_date: result.release_date,
        overview: result.overview,
        popularity: result.popularity,
        poster_path: result.poster_path,
      };
      MovieService.postMovie(this.movieToAdd).then((response) => {
        if (response.status === 200) {
          this.movieToAdd = {};
          //do something
          const resultIndex = this.results.indexOf(result);
          this.results.splice(resultIndex, 1);
        }
      });
    },

    convertGenres(result) {
      let newGenre = result.genre_ids.map((genre) => {
        return this.$store.state.genres[genre];
      });
      return newGenre.join(" ");
    },
  },
};
</script>

<style>
.result-card {
  border: 1px transparent;
  border-radius: 5px;
  background-color: hsl(0 0% 100% / 0.8);
  color: #0F0C29;
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
#search-card {
  border: 1px transparent;
  border-radius: 5px;
  background-color: hsl(0 0% 100% / 0.8);
  color: #0F0C29;
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