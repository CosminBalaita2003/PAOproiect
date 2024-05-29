package models;

public class MemberClient extends Client{

    private int noPoints;

    public MemberClient(){
        super();
    }

    public MemberClient(String name, String lastName, String email, String phone, int noPoints){
        super(name, lastName, email, phone);
        this.noPoints = noPoints;
    }

    public int getNoPoints() {
        return noPoints;
    }

    public void setNoPoints(int noPoints) {
        this.noPoints = noPoints;
    }


}
