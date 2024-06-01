package services;

import Repo.GenresRepo;
import models.Genres;

import java.util.ArrayList;
import java.util.Scanner;

public class GenresService {

    private GenresRepo genresRepo;

    public GenresService(){
        this.genresRepo = new GenresRepo();
    }

    public Genres addGenre(){
        AuditService auditService = new AuditService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the genre: ");
        String name = scanner.nextLine();
        Genres genre = new Genres(name);
        genresRepo.addGenre(genre);
        try {
            auditService.addLog("Genre added");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return genre;
    }

    public Genres getGenre(int genreId){
        return genresRepo.getGenre(genreId);
    }

    public ArrayList<Genres> deleteGenre(int genreId){
        return genresRepo.deleteGenre(genreId);
    }

    public void getAllGenres(){
        for (Genres genre : genresRepo.getAllGenres()) {
            System.out.println(genre.getGenre());
        }
    }



}
