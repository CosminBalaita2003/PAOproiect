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

    public Actor addActor(){
       Actor actor = actorService.addActor();
        System.out.println("Actor added");
        return actor;
    }

    public Actor getActor(int ind){
        Actor actor = actorService.getActor(ind);
        return actor;
    }

    public ArrayList<Actor> getAllActors(){
        return actorService.getAllActors();
    }

    public boolean updateStatus(int ind, boolean alive){
        actorService.updateStatus(ind, alive);
        return true;
    }

    public boolean deleteActor(int ind){
        return actorService.deleteActor(ind);
    }




}
