package services;

import Repo.TheaterRepo;
import models.Theater;

import java.util.ArrayList;
import java.util.Scanner;

public class TheaterService {

    private TheaterRepo theaterRepo;

    public TheaterService(){
        this.theaterRepo = new TheaterRepo();
    }

    public Theater addTheater() {
        AuditService auditService = new AuditService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of Seats: ");
        String noSeats = scanner.nextLine();

        Theater theater = new Theater(noSeats);
        theaterRepo.addTheater(theater);
        try {
            auditService.addLog("Theater added");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return theater;
    }

    public Theater getTheater(int theaterId){
        return theaterRepo.getTheater(theaterId);
    }

    public void getAllTheaters(){
        for (Theater theater : theaterRepo.getAllTheaters()) {
            System.out.println(theater.getNoSeats());
        }
    }

    public ArrayList<Theater> deleteTheater(int theaterId){
        return theaterRepo.deleteTheater(theaterId);
    }

    public boolean updateTheaterCapacity(int theaterId, String noSeats){
        Theater theater = theaterRepo.getTheater(theaterId);
        if(theater != null){
            theater.setNoSeats(noSeats);
            theaterRepo.updateTheaterCapacity(theater, noSeats);
            return true;
        }
        return false;
    }


}
