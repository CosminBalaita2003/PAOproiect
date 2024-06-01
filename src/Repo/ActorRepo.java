package Repo;
import models.Actor;

import java.util.ArrayList;

public class ActorRepo {
    ArrayList<Actor> actors = new ArrayList<>();

    public Actor addActor(Actor actor){
        actors.add(actor);
        System.out.println(actors);
        return actor;
    }

    public Actor getActor(int actorId) {
//        System.out.println(actorId + " size " + actors.size());
        for (Actor actor : actors) {
            if (actor.getActorid() == actorId) {
                return actor;
            }
        }
        return null;
    }


    public ArrayList<Actor> getAllActors() {
        return actors;
    }

    public boolean updateStatus(Actor actor, Boolean alive) {
        actor.setAlive(alive);
        return true;
    }

    public ArrayList<Actor> deleteActor(int actorId) {
        for (Actor actor : actors) {
            if (actor.getActorid() == actorId) {
                actors.remove(actor);
                return actors;
            }
        }
        return null;
    }
    public ArrayList<Actor> getActorsByFirstName(String firstName) {
        ArrayList<Actor> listaactor = new ArrayList<>();
        for (Actor actor : actors) {
            if (actor.getFirstName().equalsIgnoreCase(firstName)) {
                listaactor.add(actor);
            }
            if (!listaactor.isEmpty()) {
                return listaactor;
            }
        }
        return null;
    }

    public ArrayList<Actor> makeAllActorsAlive() {
        for (Actor actor : actors) {
            actor.setAlive(true);
        }
        return actors;
    }





}
