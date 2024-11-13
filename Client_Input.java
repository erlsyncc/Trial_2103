package vehiclerentasystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client_Input {

    String getClientID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setRentingStatus(String rented) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private class Client {
        private String clientID;
        private String clientName;
        private String clientAddress;
        private String clientContact;
        private String clientEmail;
        private String rentingStatus;

        // Constructor for the Client class
        public Client(String clientID, String clientName, String clientAddress, String clientContact, String clientEmail, String rentingStatus) {
            this.clientID = clientID;
            this.clientName = clientName;
            this.clientAddress = clientAddress;
            this.clientContact = clientContact;
            this.clientEmail = clientEmail;
            this.rentingStatus = rentingStatus;
        }

        // Getters and Setters
        public String getClientID() {
            return clientID;
        }

        public void setClientID(String clientID) {
            this.clientID = clientID;
        }

        public String getClientName() {
            return clientName;
        }

        public void setClientName(String clientName) {
            this.clientName = clientName;
        }

        public String getClientAddress() {
            return clientAddress;
        }

        public void setClientAddress(String clientAddress) {
            this.clientAddress = clientAddress;
        }

        public String getClientContact() {
            return clientContact;
        }

        public void setClientContact(String clientContact) {
            this.clientContact = clientContact;
        }

        public String getClientEmail() {
            return clientEmail;
        }

        public void setClientEmail(String clientEmail) {
            this.clientEmail = clientEmail;
        }

        public String getRentingStatus() {
            return rentingStatus;
        }

        public void setRentingStatus(String rentingStatus) {
            this.rentingStatus = rentingStatus;
        }

        @Override
        public String toString() {
            return "Client ID: " + clientID +
                    "\nName: " + clientName +
                    "\nAddress: " + clientAddress +
                    "\nContact: " + clientContact +
                    "\nEmail: " + clientEmail +
                    "\nRenting Status: " + rentingStatus + "\n";
        }
    }

    // List to store all clients
    private List<Client> clients = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);

    // Method to show all clients
    public void showClientList() {
        if (clients.isEmpty()) {
            System.out.println("No clients found.");
        } else {
            System.out.println("Client List:");
            for (Client client : clients) {
                System.out.println(client.toString());
            }
        }
    }

    // Method to add a new client
    public void addClient(String clientID, String clientName, String clientAddress, String clientContact, String clientEmail, String rentingStatus) {
        if (findClientByID(clientID) != null) {
            System.out.println("Client with ID " + clientID + " already exists.");
        } else {
            Client newClient = new Client(clientID, clientName, clientAddress, clientContact, clientEmail, rentingStatus);
            clients.add(newClient);
            System.out.println("Client added successfully.");
        }
    }

    // Method to update client information
    public void updateClient(String clientID, String newName, String newAddress, String newContact, String newEmail, String newRentingStatus) {
        Client client = findClientByID(clientID);
        if (client != null) {
            client.setClientName(newName);
            client.setClientAddress(newAddress);
            client.setClientContact(newContact);
            client.setClientEmail(newEmail);
            client.setRentingStatus(newRentingStatus);
            System.out.println("Client information updated successfully.");
        } else {
            System.out.println("Client with ID " + clientID + " not found.");
        }
    }

    // Method to delete a client
    public void deleteClient(String clientID) {
        Client client = findClientByID(clientID);
        if (client != null) {
            clients.remove(client);
            System.out.println("Client deleted successfully.");
        } else {
            System.out.println("Client with ID " + clientID + " not found.");
        }
    }

    // Helper method to find a client by their ID
    private Client findClientByID(String clientID) {
        for (Client client : clients) {
            if (client.getClientID().equals(clientID)) {
                return client;
            }
        }
        return null; // Return null if client not found
    }

    // Method to input client details from the user
    public void inputClientDetails() {
        // Prompt the user for client information
        System.out.print("Enter Client ID: ");
        String clientID = scanner.nextLine();

        System.out.print("Enter Client Name: ");
        String clientName = scanner.nextLine();

        System.out.print("Enter Client Address: ");
        String clientAddress = scanner.nextLine();

        System.out.print("Enter Client Contact: ");
        String clientContact = scanner.nextLine();

        System.out.print("Enter Client Email: ");
        String clientEmail = scanner.nextLine();

        System.out.print("Enter Renting Status (e.g., Available, Rented): ");
        String rentingStatus = scanner.nextLine();

        // Add the new client to the list
        addClient(clientID, clientName, clientAddress, clientContact, clientEmail, rentingStatus);
    }
}
