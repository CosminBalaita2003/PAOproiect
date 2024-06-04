package controller;

import models.MemberClient;
import services.MemberClientService;

import java.util.ArrayList;

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

    public void addMemberClient(MemberClient memberClient){
        memberClientService.addMemberClient(memberClient);
        System.out.println("Member Client added");
    }
    public void addMemberClient(){
        memberClientService.addMemberClient();
        System.out.println("Member Client added");
    }

    public MemberClient getMemberClient(int clientId){
        MemberClient client =memberClientService.getMemberClient(clientId);
        System.out.println(client.getName() + " " + client.getLastName() + " " + client.getEmail() + " " + client.getPhone() + " " + client.getNoPoints());
        return client;
    }

    public void getAllMemberClients(){
        memberClientService.getAllMemberClients();
    }


    public void updateNoPoints(MemberClient memberClient, int noPoints){
        memberClientService.updateNoPoints(memberClient, noPoints);
    }

    public ArrayList<MemberClient> deleteMemberClient(int clientId){
        ArrayList<MemberClient> clients = memberClientService.deleteMemberClient(clientId);
        System.out.println("Member Client deleted");
        return clients;
    }
}
