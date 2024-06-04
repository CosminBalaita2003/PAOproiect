package services;

import Repo.TicketRepo;
import models.Ticket;

import java.util.ArrayList;
import java.util.Scanner;

public class TicketService {

    private TicketRepo ticketRepo;

    public TicketService(){
        this.ticketRepo = new TicketRepo();
    }

    public Ticket addTicket(Ticket ticket){
        ticketRepo.addTicket(ticket);
        return ticket;
    }
    public Ticket addTicket(){
        AuditService auditService = new AuditService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter The movie id");
        int movieId = scanner.nextInt();
        System.out.println("Enter the theater id");
        int theaterId = scanner.nextInt();
        System.out.println("Enter show time");
        String showTime = scanner.next();
        System.out.println("Enter the seat number");
        String seat = scanner.next();
        Ticket ticket = new Ticket(movieId, theaterId, showTime, seat);
        ticketRepo.addTicket(ticket);

        try {
            auditService.addLog("Ticket added");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return ticket;

    }

    public Ticket getTicket(int ticketId) {
        return ticketRepo.getTicket(ticketId);
    }

    public void getAllTickets() {
        for (Ticket ticket : ticketRepo.getAllTickets()) {
            System.out.println(ticket.getTicketId() + " " + ticket.getMovieId() + " " + ticket.getTheaterId() + " " + ticket.getShowTime() + " " + ticket.getSeat());
        }
    }

    public boolean updateSeat(int ticketId, String seat) {
        Ticket ticket = ticketRepo.getTicket(ticketId);
        if (ticket != null) {
            ticket.setSeat(seat);
            ticketRepo.updateSeat(ticket, seat);
            return true;
        }
        return false;
    }

    public ArrayList<Ticket> deleteTicket(int ticketId) {
        return ticketRepo.deleteTicket(ticketId);
    }


}
