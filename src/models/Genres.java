package models;

public class Genres {

    private static int nextId = 1;
    private int genreId;
    private String genre;

    public Genres(){
        this.genreId = nextId;
        nextId++;
    }

    public Genres(String genre){
        this.genre = genre;
        this.genreId = nextId;
        nextId++;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public static int getNextId() {
        return nextId;
    }

    @Override
    public String toString(){
        return genre;
    }
}
