package models;

public class Theater {

    private static int nextId = 1;
    private int theaterId;

    private String noSeats;

    public Theater(){
        this.theaterId = nextId;
        nextId++;
    }

    public Theater(String noSeats){
        this.noSeats = noSeats;
        this.theaterId = nextId;
        nextId++;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public String getNoSeats() {
        return noSeats;
    }

    public void setNoSeats(String noSeats) {
        this.noSeats = noSeats;
    }

    public static int getNextId() {
        return nextId;
    }

    @Override
    public String toString(){
        return noSeats;
    }
}