package models;

public class Ticket {

    private static int nextId = 1;
    private int ticketId;

    private int movieId;

    private int theaterId;

    private String showTime;

    private String seat;

    public Ticket(){
        this.ticketId = nextId;
        nextId++;
    }

    public Ticket(int movieId, int theaterId, String showTime, String seat){
        this.movieId = movieId;
        this.theaterId = theaterId;
        this.showTime = showTime;
        this.seat = seat;
        this.ticketId = nextId;
        nextId++;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Ticket.nextId = nextId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    @Override
    public String toString(){
        return "Ticket ID: " + ticketId + "\nMovie ID: " + movieId + "\nTheater ID: " + theaterId + "\nShow Time: " + showTime + "\nSeat: " + seat;
    }

}

