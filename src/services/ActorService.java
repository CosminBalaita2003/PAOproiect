package services;

import Repo.ActorRepo;
import models.Actor;

import java.util.ArrayList;
import java.util.Scanner;

public class ActorService {

    private ActorRepo actorRepo;

    public ActorService() {
        this.actorRepo = new ActorRepo();
    }

    public Actor addActor(){
        AuditService auditService = new AuditService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first name of the actor: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter the last name of the actor: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter the birth date of the actor: ");
        String birthDate = scanner.nextLine();
        System.out.println("Is the actor alive? (true/false): ");
        boolean alive = scanner.nextBoolean();
        Actor actor = new Actor(firstName, lastName, birthDate, alive);
        actorRepo.addActor(actor);
        try {
            auditService.addLog("Actor added");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return actor;
    }

    public Actor getActor(int actorId){
        return actorRepo.getActor(actorId);
    }

    public ArrayList<Actor> getAllActors(){
        return actorRepo.getAllActors();
    }

    public boolean updateStatus(int actorId, boolean alive){
        Actor actor = actorRepo.getActor(actorId);
        if(actor != null){
            actor.setAlive(alive);
            actorRepo.updateStatus(actor, alive);
            return true;
        }
        return false;
    }

    public ArrayList<Actor> getActorsByFirstName(String firstName){
        return actorRepo.getActorsByFirstName(firstName);
    }

    public ArrayList<Actor> makeAllActorsAlive(){
        return actorRepo.makeAllActorsAlive();
    }


    public boolean deleteActor(int actorId){
        return actorRepo.deleteActor(actorId);
    }



}
