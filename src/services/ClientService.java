package services;

import Repo.ClientRepo;

import java.util.ArrayList;
import java.util.Scanner;

import models.Client;
import models.MemberClient;

public class ClientService {

    private ClientRepo clientRepo;

    public ClientService(){
        clientRepo = new ClientRepo();
    }

    public Client addClient(){
        AuditService auditService = new AuditService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first name of the client: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter the last name of the client: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter the email of the client: ");
        String email = scanner.nextLine();
        System.out.println("Enter the phone number of the client: ");
        String phone = scanner.nextLine();

            Client client = new Client(firstName, lastName, email, phone);
            clientRepo.addClient(client);

        try {
            auditService.addLog("Client added");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


        return client;
    }


    public Client getClient(int clientId) {
        return clientRepo.getClient(clientId);
    }

    public void getAllClients() {
        for (Client client : clientRepo.getAllClients()) {
            System.out.println(client.getClientId() + " " + client.getName() + " " + client.getLastName() + " " + client.getEmail() + " " + client.getPhone());
        }
    }

    public ArrayList<Client> deleteClient(int clientId) {
        return clientRepo.deleteClient(clientId);
    }


}
