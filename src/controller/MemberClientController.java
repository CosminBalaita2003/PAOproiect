package controller;

import models.MemberClient;
import services.MemberClientService;

public class MemberClientController
{
    private static MemberClientController instance;
    private MemberClientService memberClientService;

    private MemberClientController(){
        memberClientService = new MemberClientService();
    }

    public static MemberClientController getInstance(){
        if(instance == null){
            synchronized (MemberClientController.class){
                if(instance == null){
                    instance = new MemberClientController();
                }
            }
        }
        return instance;
    }

    public void addMemberClient(){
        memberClientService.addMemberClient();
        System.out.println("Member Client added");
    }

    public MemberClient getMemberClient(int clientId){
        MemberClient client =memberClientService.getMemberClient(clientId);
        return client;
    }

    public void getAllMemberClients(){
        memberClientService.getAllMemberClients();
    }

    public void deleteMemberClient(int clientId){
        memberClientService.deleteMemberClient(clientId);
    }

    public void updateNoPoints(MemberClient memberClient, int noPoints){
        memberClientService.updateNoPoints(memberClient, noPoints);
    }
}
