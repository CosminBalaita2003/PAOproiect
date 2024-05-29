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
        System.out.println(actorId + " " + actors.size());
        if (actorId < actors.size()) {
            return actors.get(actorId);
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

    public boolean deleteActor(int actorId) {
        if (actorId < actors.size()) {
            actors.remove(actorId);
            return true;
        }
        return false;
    }





}
