package Repo;

import models.Ticket;

import java.util.ArrayList;

public class TicketRepo {
    ArrayList<Ticket> tickets = new ArrayList<>();

    public Ticket addTicket(Ticket ticket){
        tickets.add(ticket);
        System.out.println(tickets);
        return ticket;
    }

    public Ticket getTicket(int ticketId) {
        System.out.println(ticketId + " " + tickets.size());
        if (ticketId < tickets.size()) {
            return tickets.get(ticketId);
        }
        return null;
    }

    public ArrayList<Ticket> getAllTickets() {
        return tickets;
    }

    public boolean updateSeat(Ticket ticket, String seat) {
        ticket.setSeat(seat);
        return true;
    }

    public boolean deleteTicket(int ticketId) {
        if (ticketId < tickets.size()) {
            tickets.remove(ticketId);
            return true;
        }
        return false;
    }
}
