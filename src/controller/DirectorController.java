package controller;

import models.Director;
import services.DirectorService;

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

    public void deleteDirector(int directorId){
        directorService.deleteDirector(directorId);
    }

    public void updateStatus(int id, boolean alive){
        directorService.updateStatus(id, alive);
    }
}
