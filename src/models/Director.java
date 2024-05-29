package models;

public class Director {

    private static int nextId = 1;
    private int directorId;
    private String firstname;
    private String lastName;
    private String birthDate;
    private boolean alive;

    public Director(){
        this.directorId = nextId;
        nextId++;
    }

    public Director(String name, String lastName, String birthDate, boolean alive){
        this.firstname = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.alive = alive;
        this.directorId = nextId;
        nextId++;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Director.nextId = nextId;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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

    @Override
    public String toString(){
        return firstname + " " + lastName;
    }
}
