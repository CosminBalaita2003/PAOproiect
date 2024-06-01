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
        for (MemberClient memberClient : memberClients) {
            if (memberClient.getClientId() == memberClientId) {
                return memberClient;
            }
        }
        return null;
    }

    public ArrayList<MemberClient> getAllMemberClients() {
        return memberClients;
    }

    public ArrayList<MemberClient> deleteMemberClient(int memberClientId) {
        for (MemberClient memberClient : memberClients){
            if (memberClient.getClientId() == memberClientId) {
                memberClients.remove(memberClientId);
                return memberClients;
            }

        }
        return null;

    }

    public boolean updateNoPoints(MemberClient memberClient, int noPoints) {
        memberClient.setNoPoints(noPoints);
        return true;
    }
}
