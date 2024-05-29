package Repo;

import models.MemberClient;

import java.util.ArrayList;

public class MemberClientRepo {

    ArrayList<MemberClient> memberClients = new ArrayList<>();

    public MemberClient addMemberClient(MemberClient memberClient){
        memberClients.add(memberClient);
        System.out.println(memberClients);
        return memberClient;
    }

    public MemberClient getMemberClient(int memberClientId) {
        System.out.println(memberClientId + " " + memberClients.size());
        if (memberClientId < memberClients.size()) {
            return memberClients.get(memberClientId);
        }
        return null;
    }

    public ArrayList<MemberClient> getAllMemberClients() {
        return memberClients;
    }

    public boolean deleteMemberClient(int memberClientId) {
        if (memberClientId < memberClients.size()) {
            memberClients.remove(memberClientId);
            return true;
        }
        return false;
    }

    public boolean updateNoPoints(MemberClient memberClient, int noPoints) {
        memberClient.setNoPoints(noPoints);
        return true;
    }
}
