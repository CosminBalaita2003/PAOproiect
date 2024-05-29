package controller;

import services.MovieService;

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

    public void getMovie(int movieId) {
        movieService.getMovie(movieId);
    }

    public void getAllMovies() {
        movieService.getAllMovies();
    }

    public void deleteMovie(int movieId) {
        movieService.deleteMovie(movieId);
    }

    public void updateRating(int id, String rating) {
        movieService.updateRating(id, rating);
    }
}

