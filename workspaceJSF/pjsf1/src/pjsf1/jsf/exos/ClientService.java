package pjsf1.jsf.exos;

import java.util.ArrayList;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="clientservice")
@ApplicationScoped
public class ClientService {

	ArrayList<Client> clients = new ArrayList<Client>();
	
	public ClientService(){

		clients.add(new Client("Dupont", "Jean"));
		clients.add(new Client("Durand", "Paul"));
	}
	
	public ArrayList<Client> getClients(){
		return clients;
	}

	public int getNombre(){
		return clients.size();
	}
	
	public void delete(Client client){
		clients.remove(client);
	}

	public void add(Client client){
		clients.add(client);

	}


}
