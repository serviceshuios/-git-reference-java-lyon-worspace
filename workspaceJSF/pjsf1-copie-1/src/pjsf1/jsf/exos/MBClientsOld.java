package pjsf1.jsf.exos;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="mbclients", eager=true)
@SessionScoped
public class MBClientsOld {

	ArrayList<Client> clients = new ArrayList<Client>();
	
	public MBClientsOld(){
		//System.out.println("Constructeur MBClients");
		clients.add(new Client("Dupont", "Jean"));
		clients.add(new Client("Durand", "Paul"));
	}
	
	public ArrayList<Client> getClients(){
		//System.out.println("get MBClients");
		return clients;
	}

	public int getNombre(){
		return clients.size();
	}
	
	
	private Client clientCourant;
	
	public Client getClientCourant(){
		return clientCourant;
	}
	
	public String select(Client client){
		
		this.clientCourant = client;
		return "clientDisplay";
	}

	public String delete(){
		clients.remove(clientCourant);
		return "clients";
	}

	Client newClient = new Client("","");
	
	public Client getNewClient() {
		return newClient;
	}

	public void setNewClient(Client newClient) {
		this.newClient = newClient;
	}

	public String add(){
		clients.add(newClient);
		newClient = new Client("","");
		return "clients";
	}


}
