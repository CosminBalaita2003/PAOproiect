package controller;

import services.TheaterService;

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

    public void deleteTheater(int theatreId) {
        theaterService.deleteTheater(theatreId);
    }


}
