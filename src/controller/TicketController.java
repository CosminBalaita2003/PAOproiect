package controller;

import services.TicketService;

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

    public void deleteTicket(int ticketId) {
        ticketService.deleteTicket(ticketId);
    }


}
