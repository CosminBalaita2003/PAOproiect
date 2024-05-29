package controller;

import models.Client;
import services.ClientService;

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
        return clientService.getClient(clientId);
    }

    public void getAllClients(){
        clientService.getAllClients();
    }

    public boolean deleteClient(int clientId){
        return clientService.deleteClient(clientId);
    }


}
