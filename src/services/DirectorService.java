package services;

import Repo.DirectorRepo;
import models.Director;

import java.util.ArrayList;
import java.util.Scanner;

public class DirectorService {

    private DirectorRepo directorRepo;

    public DirectorService(){
        this.directorRepo = new DirectorRepo();
    }

    public Director addDirector(Director director){
        directorRepo.addDirector(director);
        return director;
    }
    public Director addDirector(){
        AuditService auditService = new AuditService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first name of the director: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter the last name of the director: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter the birth date of the director: ");
        String birthDate = scanner.nextLine();
        System.out.println("Is the director alive? (true/false): ");
        boolean alive = scanner.nextBoolean();
        Director director = new Director(firstName, lastName, birthDate, alive);
        directorRepo.addDirector(director);
        try {
            auditService.addLog("Director added");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return director;

    }

    public Director getDirector(int directorId){
        return directorRepo.getDirector(directorId);
    }

    public void getAllDirectors(){
        for (Director director : directorRepo.getAllDirectors()) {
            System.out.println(director.getFirstname() + " " + director.getLastName());
        }
    }

    public boolean updateStatus(int directorId, boolean alive){
        Director director = directorRepo.getDirector(directorId);
        if(director != null){
            director.setAlive(alive);
            directorRepo.updateStatus(director, alive);
            return true;
        }
        return false;
    }

    public ArrayList<Director> deleteDirector(int directorId){
        return directorRepo.deleteDirector(directorId);
    }


}
