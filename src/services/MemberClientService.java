package services;

import Repo.MemberClientRepo;
import models.MemberClient;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberClientService {

    MemberClientRepo memberClientRepo;

    public MemberClientService(){
        memberClientRepo = new MemberClientRepo();
    }

    public void addMemberClient(){
       AuditService auditService = new AuditService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first name of the member client: ");
String firstName = scanner.nextLine();
        System.out.println("Enter the last name of the member client: ");
String lastName = scanner.nextLine();
        System.out.println("Enter the email of the member client: ");
String email = scanner.nextLine();
        System.out.println("Enter the phone number of the member client: ");
String phone = scanner.nextLine();
        System.out.println("Enter the number of points of the member client: ");
int noPoints = scanner.nextInt();
        MemberClient memberClient = new MemberClient(firstName, lastName, email, phone, noPoints);
        memberClientRepo.addMemberClient(memberClient);
        try {
            auditService.addLog("Member client added");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public MemberClient getMemberClient(int memberClientId){
        return memberClientRepo.getMemberClient(memberClientId);
    }

    public void getAllMemberClients(){
        for (MemberClient memberClient : memberClientRepo.getAllMemberClients()) {
            System.out.println(memberClient.getClientId() + " " + memberClient.getName() + " " + memberClient.getLastName() + " " + memberClient.getEmail() + " " + memberClient.getPhone() + " " + memberClient.getNoPoints());
        }
    }

    public ArrayList<MemberClient> deleteMemberClient(int memberClientId){
        return memberClientRepo.deleteMemberClient(memberClientId);
    }

    public boolean updateNoPoints(MemberClient memberClient, int noPoints){
        return memberClientRepo.updateNoPoints(memberClient, noPoints);
    }


}
