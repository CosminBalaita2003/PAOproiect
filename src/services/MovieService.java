package services;

import Repo.MovieRopo;
import models.Director;
import models.Genres;
import models.Movie;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieService {

    private MovieRopo movieRopo;

    public MovieService(){
        this.movieRopo = new MovieRopo();
    }

    public Movie addMovie(Movie movie){
        movieRopo.addMovie(movie);
        return movie;
    }
    public Movie addMovie(){
        AuditService auditService = new AuditService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the title of the movie: ");
        String title = scanner.nextLine();
        System.out.println("Enter the genre of the movie: ");
        String genre = scanner.nextLine();
        Genres genres = new Genres(genre);

        System.out.println("Enter the name of the director: ");
        String name = scanner.nextLine();
        Director director = new Director(name,"","",true);

        System.out.println("Enter the duration of the movie: ");
        String d = scanner.nextLine();
        int duration = Integer.parseInt(d);
        System.out.println("Enter the rating of the movie: ");
        String rating = scanner.nextLine();
        Movie movie = new Movie(title, genres, director, duration, rating);
        movieRopo.addMovie(movie);
        try {
            auditService.addLog("Movie added");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return movie;}

    public Movie getMovie(int movieId){
        return movieRopo.getMovie(movieId);

    }

    public ArrayList<Movie> getAllMovies(){
        for (Movie movie : movieRopo.getAllMovies()) {
            System.out.println(movie.getTitle());
        }
        return movieRopo.getAllMovies();
    }

    public ArrayList<Movie> deleteMovie(int movieId){
        return movieRopo.deleteMovie(movieId);
    }

    public boolean updateRating(int movieId, String rating){
        Movie movie = movieRopo.getMovie(movieId);
        if(movie != null){
            movie.setRating(rating);
            movieRopo.updateRating(movie, rating);
            return true;
        }
        return false;
    }
}
