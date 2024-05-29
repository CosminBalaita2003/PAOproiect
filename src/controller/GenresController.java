package controller;

import services.GenresService;

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

    public void deleteGenre(int genreId){
        genresService.deleteGenre(genreId);
    }



}
