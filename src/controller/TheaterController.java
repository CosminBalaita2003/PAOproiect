package controller;

import models.Theater;
import services.TheaterService;

import java.util.ArrayList;

public class TheaterController {

    private static TheaterController instance;
    private TheaterService theaterService;

    private TheaterController() {
        theaterService = new TheaterService();
    }

public static TheaterController getInstance() {
        if (instance == null) {
            synchronized (TheaterController.class) {
                if (instance == null) {
                    instance = new TheaterController();
                }
            }
        }
        return instance;
    }

    public void addTheater() {
        theaterService.addTheater();
        System.out.println("Theatre added");
    }

    public void getTheater(int theatreId) {
        theaterService.getTheater(theatreId);
    }

    public void getAllTheaters() {
        theaterService.getAllTheaters();
    }

    public ArrayList<Theater> deleteTheater(int theatreId) {
        ArrayList<Theater> theaters = theaterService.deleteTheater(theatreId);
        System.out.println("Theatre deleted");
        return theaters;
    }


}
