package Repo;

import models.Client;

import java.util.ArrayList;

public class ClientRepo {

    ArrayList<Client> clients = new ArrayList<>();

    public Client addClient(Client client){
        clients.add(client);
        System.out.println(clients);
        return client;
    }

    public Client getClient(int clientId) {
        System.out.println(clientId + " " + clients.size());
        if (clientId < clients.size()) {
            return clients.get(clientId);
        }
        return null;
    }

    public ArrayList<Client> getAllClients() {
        return clients;
    }


    public boolean deleteClient(int clientId) {
        if (clientId < clients.size()) {
            clients.remove(clientId);
            return true;
        }
        return false;
    }


}
