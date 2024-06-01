package controller;

import models.Director;
import services.DirectorService;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DirectorController {

    private static DirectorController instance;
    private DirectorService directorService;

    private DirectorController(){
        directorService = new DirectorService();
    }

    public static DirectorController getInstance(){
        if(instance == null){
            synchronized (DirectorController.class){
                if(instance == null){
                    instance = new DirectorController();
                }
            }
        }
        return instance;
    }

    public void addDirector(){
        directorService.addDirector();
        System.out.println("Director added");
    }

    public void getDirector(int directorId){
        directorService.getDirector(directorId);
    }

    public void getAllDirectors(){
        directorService.getAllDirectors();
    }

    public ArrayList<Director> deleteDirector(int directorId){
        ArrayList<Director> directors = directorService.deleteDirector(directorId);
        System.out.println("Director deleted");
        return directors;
    }

    public void updateStatus(int id, boolean alive){
        directorService.updateStatus(id, alive);
    }
}
