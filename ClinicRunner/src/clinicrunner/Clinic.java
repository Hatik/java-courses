/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicrunner;

import java.util.List;
import java.util.ArrayList;

public class Clinic {
  private final List<Client> clients;
  
  public Clinic()
  {
      clients = new ArrayList<>();
  }
  
  public List<Client> getClients()
  {
      return clients;
  }
  
  public void addClient(final Client client)
  {
      clients.add(client);
  }
  
  public void deleteClient(final Client client)
  {
      clients.remove(client);
  }
  
  public Client findClient(String clientName)
  {
      Client client = null;
      for(Client cl : clients)
      {
          if(clientName.equalsIgnoreCase(cl.getName())){
              client = cl;
              break;
          }
      }
      return client;
  }
  
  public List<Client> returnAll(){
      return clients;
  }
}
