/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicrunner;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Admin
 */
public class Client {
    private String clientName;
    private final List<Pet> pets;
    
    public Client(String clientName)
    {
        this.clientName = clientName;
        this.pets = new ArrayList<>();
    }
    
    public void setName(String name)
    {
        this.clientName = name;
    }
    
    public String getName(){
        return this.clientName;
    }
    
    public void deletePet(final String petName){
        for (int i = 0; i < pets.size(); i++)
        {
            if(petName.equalsIgnoreCase(pets.get(i).getName()))
            {
                pets.remove(i);
            }
        }
    }
    
    public Pet getPet(String petName)
    {
        Pet foundPet = null;
        for(Pet pet:pets)
        {
            if(petName.equalsIgnoreCase(pet.getName()))
            {
                foundPet = pet;
                break;
            }
        }
        return foundPet;
    }
    
    public boolean canAddPet(final String petName)
    {
        boolean canAdd = true;
        for(Pet pet : pets)
        {
            if (petName.equalsIgnoreCase(pet.getName()))
            {
                canAdd = false;
                break;
            }
        }
        return canAdd;
    }
    
    public void addPet(Pet pet) throws DuplicateNameException {
            if (canAddPet(pet.getName()))
            {
                pets.add(pet);
            }
            else
            {
                throw new DuplicateNameException("Pet with this nickname already exists");
            }
    }
    
    public List<Pet> getPets()
    {
        return this.pets;
    }
}
