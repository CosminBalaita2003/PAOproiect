package models;

public class Movie {

    private String title;
    private Genres genre;
    private Director director;
    private int duration;
    private String rating;
    private static int nextId = 1;
    private int movieId;

    public Movie(){
        this.movieId = nextId;
        nextId++;
    }

    public Movie(String title, Genres genre, Director director, int duration, String rating){
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.duration = duration;
        this.rating = rating;
        this.movieId = nextId;
        nextId++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genres getGenre() {
        return genre;
    }

    public void setGenre(Genres genre) {
        this.genre = genre;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Movie.nextId = nextId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

@Override
    public String toString(){
        return "Movie ID: " + movieId + "\nTitle: " + title + "\nGenre: " + genre + "\nDirector: " + director + "\nDuration: " + duration + "\nRating: " + rating;
    }

}
