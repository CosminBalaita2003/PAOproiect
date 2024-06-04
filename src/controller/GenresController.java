package controller;

import models.Genres;
import services.GenresService;

import java.util.ArrayList;

public class GenresController {

    private static GenresController instance;

    private GenresService genresService;
    private GenresController(){
        genresService = new GenresService();
    }

    public static GenresController getInstance(){
        if(instance == null){
            synchronized (GenresController.class){
                if(instance == null){
                    instance = new GenresController();
                }
            }
        }
        return instance;
    }
    public void addGenre(Genres genre){
        genresService.addGenre(genre);
        System.out.println("Genre added");
    }
    public void addGenre(){
        genresService.addGenre();
        System.out.println("Genre added");
    }

    public void getGenre(int genreId){
        genresService.getGenre(genreId);
    }

    public void getAllGenres(){
        genresService.getAllGenres();
    }

    public ArrayList<Genres> deleteGenre(int genreId){
        ArrayList<Genres> genres = genresService.deleteGenre(genreId);
        System.out.println("Genre deleted");
        return genres;
    }



}
