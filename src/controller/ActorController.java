package controller;

import models.Actor;
import services.ActorService;

import java.util.ArrayList;

public class ActorController {

    private static ActorController instance;

    private ActorService actorService;

    private ActorController(){
        actorService = new ActorService();
    }

    public static ActorController getInstance(){
        if(instance == null){
            synchronized (ActorController.class){
                if(instance == null){
                    instance = new ActorController();
                }
            }
    }
        return instance;
    }

    public Actor addActor(Actor actor){
        actorService.addActor(actor);
        System.out.println("Actor added");
        return actor;
    }
    public Actor addActor(){
       Actor actor = actorService.addActor();
        System.out.println("Actor added");
        return actor;
    }

    public Actor getActor(int ind){
        Actor actor = actorService.getActor(ind);
        System.out.println("Actor found");
        System.out.println(STR."\{actor.getFirstName()} \{actor.getLastName()} \{actor.getBirthDate()} \{actor.isAlive()}");
        return actor;
    }

    public ArrayList<Actor> getAllActors(){
        ArrayList<Actor> actors = actorService.getAllActors();
        System.out.println("All actors found");
        for (Actor actor : actors) {
            System.out.println(actor.getFirstName() + " " + actor.getLastName() + " " + actor.getBirthDate() + " " + actor.isAlive());
        }

        return actorService.getAllActors();
    }

    public ArrayList<Actor> getActorsByFirstName(String firstName){
        ArrayList<Actor> actors = actorService.getActorsByFirstName(firstName);
        System.out.println("Actors found by first name");
        for (Actor actor : actors) {
            System.out.println(actor.getFirstName() + " " + actor.getLastName() + " " + actor.getBirthDate() + " " + actor.isAlive());
        }
        return actors;
    }

    public ArrayList<Actor> makeAllActorsAlive(){
        ArrayList<Actor> actors = actorService.makeAllActorsAlive();
        System.out.println("All actors are alive");
        for (Actor actor : actors) {
            System.out.println(actor.getFirstName() + " " + actor.getLastName() + " " + actor.getBirthDate() + " " + actor.isAlive());
        }
        return actors;
    }
    public boolean updateStatus(int ind, boolean alive){
        actorService.updateStatus(ind, alive);
        return true;
    }

    public ArrayList<Actor> deleteActor(int ind){
        ArrayList<Actor> actors = actorService.deleteActor(ind);
        System.out.println("Actor deleted");
        return actors;
    }




}
