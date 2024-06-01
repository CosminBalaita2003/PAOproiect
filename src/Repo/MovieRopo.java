package Repo;

import models.Movie;

import java.util.ArrayList;

public class MovieRopo {

    ArrayList<Movie> movies = new ArrayList<>();

    public Movie addMovie(Movie movie){
        movies.add(movie);
        System.out.println(movies);
        return movie;
    }

    public Movie getMovie(int movieId) {
        System.out.println(movieId + " " + movies.size());
        for (Movie movie : movies) {
            if (movie.getMovieId() == movieId) {
                return movie;
            }
        }
        return null;
    }

    public ArrayList<Movie> getAllMovies() {
        return movies;
    }

    public boolean deleteMovie(int movieId) {
        if (movieId < movies.size()) {
            movies.remove(movieId);
            return true;
        }
        return false;
    }

    public boolean updateRating(Movie movie, String rating) {
        movie.setRating(rating);
        return true;
    }
    
}
