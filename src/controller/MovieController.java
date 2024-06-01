package controller;

import models.Movie;
import services.MovieService;

import java.util.ArrayList;

public class MovieController {
    private static MovieController instance;

    private MovieService movieService;

    private MovieController() {
        movieService = new MovieService();
    }

    public static MovieController getInstance() {
        if (instance == null) {
            synchronized (MovieController.class) {
                if (instance == null) {
                    instance = new MovieController();
                }
            }
        }
        return instance;
    }

    public void addMovie() {
        movieService.addMovie();
        System.out.println("Movie added");
    }

    public Movie getMovie(int movieId) {
        System.out.println("Movie found");
        Movie movie = movieService.getMovie(movieId);
        System.out.println(movie.getTitle() + " " + movie.getGenre() + " " + movie.getDirector() + " " + movie.getDuration() + " " + movie.getRating());


        return movie;
    }

    public ArrayList<Movie> getAllMovies() {
        ArrayList<Movie> movies = movieService.getAllMovies();
        System.out.println("All movies found");
        for (Movie movie : movies) {
            System.out.println(movie.getTitle() + " " + movie.getGenre() + " " + movie.getDirector() + " " + movie.getDuration() + " " + movie.getRating());
        }

        return movieService.getAllMovies();
    }


    public void updateRating(int id, String rating) {
        movieService.updateRating(id, rating);
    }

    public ArrayList<Movie> deleteMovie(int movieId) {
        ArrayList<Movie> movies = movieService.deleteMovie(movieId);
        System.out.println("Movie deleted");
        return movies;
    }
}

