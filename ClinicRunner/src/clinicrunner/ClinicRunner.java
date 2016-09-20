/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicrunner;

import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.InputMismatchException;
import java.util.List;
/**
 *
 * @author Admin
 */
public class ClinicRunner {
 private Scanner input;
 private Clinic clinic;
 public ClinicRunner()
 {
    input = new Scanner(System.in);
        clinic = new Clinic();
        runExec(); 
 }
 
    public static void main(String[] args) {

        new ClinicRunner();
    }
    
    private void printMainMenu(){
        System.out.println();
        System.out.println("*** Choose Action: ***");
        System.out.println("1. Add client");
        System.out.println("2. Add pet to the client");
        System.out.println("3. Find client by name");
        System.out.println("4. Find pet by nickname");
        System.out.println("5. Change client name");
        System.out.println("6. Change pet nickname");
        System.out.println("7. Delete client");
        System.out.println("8. Delete pet");
        System.out.println("9. Show all");
        System.out.println("10.Exit");
    }
    
    private String getUserWordAnswer(final String question){
        System.out.println(question);
        String answer;
        try{
            answer = input.nextLine();
        }
        catch (NoSuchElementException exc){
            answer = "";
            System.out.println(exc.getMessage());
        }
        return answer;
    }
    
    private void runExec()
    {
        int userChoice = 0;
        while(userChoice != 10)
        {
            printMainMenu();
            try{
            userChoice = input.nextInt();   
            input.nextLine();
            
            switch(userChoice){
                case 1:
                    addNewClientExec();
                    break;
                case 2:
                    addNewPetToClientExec();
                    break;
                case 3:
                    findClientExec();
                    break;
                case 4:
                    findPetExec();
                    break;
                case 5:
                    changeClientNameExec();
                    break;
                case 6:
                    changePetNameExec();
                    break;
                case 7:
                    deleteClientExec();
                    break;
                case 8:
                    deletePetExec();
                    break;
                case 9:
                    showAllExec();
                    break;
                    
            }
            }
            catch(InputMismatchException exc){
                System.out.println(exc.getMessage());
                userChoice = 0;
            }
        }
    }
    
    private void addNewClientExec(){
        String name;
        Client client;
        do{
            name = getUserWordAnswer("Enter client name: ");
        }
        while(name.equals(""));
        client = new Client(name);
        clinic.addClient(client);
        System.out.println("Client has been added.");
    }
    private Pet addNewPet()
    {   
        
        String petKind = getUserWordAnswer("What kind of pet do you want to add? (Cat or Dog): ");
        while(!petKind.equalsIgnoreCase("dog") && !petKind.equalsIgnoreCase("cat"))
        {
            petKind = getUserWordAnswer("Unknown pet kind. Try again");
        }
        String petName = getUserWordAnswer("Enter pet nickname: ");
        Pet pet = null;
        if(petKind.equalsIgnoreCase("cat"))
        {
            pet = new Cat(petName);
        }
        else if(petKind.equalsIgnoreCase("dog"))
        {
            pet = new Dog(petName);
        }
        return pet;
    }
    
    private void addNewPetToClientExec(){
        Client client = findClient();
        if (client == null){
            System.out.println("Client with such name is not found");
        }
        else{
            Pet pet = addNewPet();
            try{
                client.addPet(pet);
                System.out.println("Pet has been added");
            }
            catch(DuplicateNameException exc){
                System.out.println("Error while adding: " + exc.getMessage());
            }
            
    }
    }
    
    private Client findClient(){
        String clientName = getUserWordAnswer("Enter client name: ");
        return clinic.findClient(clientName);
    }
    
    private void findClientExec()
    {
        Client client = findClient();
        if(client == null)
        {
            System.out.println("Client with such name was not found.");
        }
        else 
        {
            System.out.println("Client: " + client.getName() + " found.");
            for(Pet pet : client.getPets()){
                System.out.println(pet.toString() + " - " + pet.getName());
            }
            System.out.println("Search finished");
        }
    }
    
    private void findPetExec()
    {
        String petName = getUserWordAnswer("Enter the nickname of the pet: ");
        for(Client client : clinic.getClients())
        {
            for(Pet pet : client.getPets())
            {
                if(pet.getName().equalsIgnoreCase(petName)){
                    System.out.println("Client: " + client.getName() + ", " + 
                            pet.toString() + " - " + pet.getName());
                }
            }
        }
        System.out.println("Search finished");
    }
    
    private void changeClientNameExec()
    {
        String name;
        Client client;
        client = findClient();
        if(client == null)
        {
            System.out.println("Client with such name was not found.");
        }
        else{
            do{
            name = getUserWordAnswer("Enter new name for the client");
            }
            while(name.equals(""));
            
            client.setName(name);
            System.out.println("Client Name has been modified");
            
        }
    }
    
    private void changePetNameExec()
    {
        Client client = findClient();
        
        if(client == null)
        {
            System.out.println("Client was not found");
        }
        else
        {
            String petName = getUserWordAnswer("Enter nickname to be modified: ");
            Pet pet = client.getPet(petName);
            if(pet == null)
            {
                System.out.println("Pet with such nickname was not found.");
            }
            else{
                String newPetName = getUserWordAnswer("Enter new nickname of the pet");
                pet.setName(newPetName);
                System.out.println("Pet nickname was modified.");
            }
        }
    }
    
    private void deleteClientExec()
    {
        Client client = findClient();
        if(client == null){
            System.out.println("Client was not found.");
        }
        else{
            clinic.deleteClient(client);
            System.out.println("Client has been deleted.");
        }
    }
    
    private void deletePetExec(){
        Client client = findClient();
        if(client == null){
            System.out.println("Client was not found.");
        }
        else{
            String petName = getUserWordAnswer("Enter name of the pet to be deleted: ");
            Pet pet = client.getPet(petName);
            if(pet == null)
            {
                System.out.println("Pet with such nickname was not found.");
            }
            else
            {
                client.deletePet(petName);
                System.out.println("Pet has been deleted.");
        }
    }
}
    private void showAllExec(){
        List<Client> clients = clinic.returnAll();
        if(clients == null)
        {
            System.out.println("Clinic is empty");
        }
        else
        {
            for(Client client : clients)
            {
                System.out.println("Name: " + client.getName());
                for(Pet pet : client.getPets()){
                System.out.println(pet.toString() + " - " + pet.getName());
            }
            
            }
            //System.out.println("Search finished");
        }
    }
}
