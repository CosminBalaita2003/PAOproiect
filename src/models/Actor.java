package models;

public class Actor {
    private String firstName;
    private String lastName;
    private String birthDate;
    private  boolean alive;
    private static int nextId = 1;
    private int Actorid;

    public Actor(){
        this.Actorid = nextId;
        nextId++;
    }

    public Actor(String firstName, String lastName, String birthDate, boolean alive){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.alive = alive;
        this.Actorid = nextId;
        nextId++;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Actor.nextId = nextId;
    }

    public int getActorid() {
        return Actorid;
    }

    public void setActorid(int actorid) {
        Actorid = actorid;
    }

    @Override
    public String toString(){
        return "Actor{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", alive=" + alive +
                ", Actorid=" + Actorid +
                '}';
    }

}
