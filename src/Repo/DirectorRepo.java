package Repo;

import models.Director;

import java.util.ArrayList;

public class DirectorRepo {

    ArrayList<Director> directors = new ArrayList<>();

    public Director addDirector(Director director){
        directors.add(director);
        System.out.println(directors);
        return director;
    }

    public Director getDirector(int directorId) {
        System.out.println(directorId + " " + directors.size());
        if (directorId < directors.size()) {
            return directors.get(directorId);
        }
        return null;
    }

    public ArrayList<Director> getAllDirectors() {
        return directors;
    }

    public boolean updateStatus(Director director, Boolean alive) {
        director.setAlive(alive);
        return true;
    }

    public ArrayList<Director> deleteDirector(int directorId) {
        for (Director director : directors){
            if (director.getDirectorId() == directorId) {
                directors.remove(directorId);
                return directors;
            }

        }
        return null;
    }


}
