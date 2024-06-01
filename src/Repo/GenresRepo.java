package Repo;

import models.Genres;

import java.util.ArrayList;

public class GenresRepo {

    ArrayList<Genres> genres = new ArrayList<>();

    public Genres addGenre(Genres genre){
        genres.add(genre);
        System.out.println(genres);
        return genre;
    }

    public Genres getGenre(int genreId) {
        System.out.println(genreId + " " + genres.size());
        if (genreId < genres.size()) {
            return genres.get(genreId);
        }
        return null;
    }

    public ArrayList<Genres> getAllGenres() {
        return genres;
    }

    public ArrayList<Genres> deleteGenre(int genreId) {
        for (Genres genre : genres){
            if (genre.getGenreId() == genreId) {
                genres.remove(genreId);
                return genres;
            }

        }
        return null;
    }


}
