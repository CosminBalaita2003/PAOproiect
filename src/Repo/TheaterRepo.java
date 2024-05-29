package Repo;

import models.Theater;

import java.util.ArrayList;

public class TheaterRepo {

    ArrayList<Theater> theaters = new ArrayList<>();

    public Theater addTheater(Theater theater){
        theaters.add(theater);
        System.out.println(theaters);
        return theater;
    }

    public Theater getTheater(int theaterId) {
        System.out.println(theaterId + " " + theaters.size());
        if (theaterId < theaters.size()) {
            return theaters.get(theaterId);
        }
        return null;
    }

    public ArrayList<Theater> getAllTheaters() {
        return theaters;
    }

    public boolean deleteTheater(int theaterId) {
        if (theaterId < theaters.size()) {
            theaters.remove(theaterId);
            return true;
        }
        return false;
    }

    public boolean updateTheaterCapacity(Theater theater, String noSeats) {
        theater.setNoSeats(noSeats);
        return true;
    }

}
