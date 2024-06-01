package controller;

import models.Ticket;
import services.TicketService;

import java.util.ArrayList;

public class TicketController {

    private static TicketController instance;

    private TicketService ticketService;

    private TicketController() {
        ticketService = new TicketService();
    }

    public static TicketController getInstance() {
        if (instance == null) {
            synchronized (TicketController.class) {
                if (instance == null) {
                    instance = new TicketController();
                }
            }
        }
        return instance;
    }

    public void addTicket() {
        ticketService.addTicket();
        System.out.println("Ticket added");
    }

    public void getTicket(int ticketId) {
        ticketService.getTicket(ticketId);
    }

    public void getAllTickets() {
        ticketService.getAllTickets();
    }


    public ArrayList<Ticket> deleteTicket(int ticketId) {
        ArrayList<Ticket> tickets = ticketService.deleteTicket(ticketId);
        System.out.println("Ticket deleted");
        return tickets;
    }

}
