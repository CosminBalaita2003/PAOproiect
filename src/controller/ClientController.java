package controller;

import models.Client;
import services.ClientService;

import java.util.ArrayList;

public class ClientController {

    private static ClientController instance;
    private ClientService clientService;

    private ClientController(){
        clientService = new ClientService();
    }

    public static ClientController getInstance(){
        if(instance == null){
            synchronized (ClientController.class){
                if(instance == null){
                    instance = new ClientController();
                }
            }
        }
        return instance;
    }

    public Client addClient(){
        Client client = clientService.addClient();
        System.out.println("Client added");
        return client;
    }

    public Client getClient(int clientId){
        System.out.println("Client found");
        Client client = clientService.getClient(clientId);
        System.out.println(client.getName() + " " + client.getLastName() + " " + client.getEmail() + " " + client.getPhone());
        return clientService.getClient(clientId);
    }

    public void getAllClients(){
        clientService.getAllClients();
    }

    public ArrayList<Client> deleteClient(int clientId){
        ArrayList<Client> clients = clientService.deleteClient(clientId);
        System.out.println("Client deleted");
        return clients;
    }


}
