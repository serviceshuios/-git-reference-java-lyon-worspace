package dao;

import java.util.List;

import metier.Client;

public interface IDao {
	public long addClient(Client c);
	public List<Client> getAllClients();
	public void delete(Client c);
	public void maj(Client c);
}
