package service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import dao.IDao;
import metier.Client;

@Named
public class ServiceImpl implements Iservice, Serializable {

	@Inject
	private IDao dao;
	@Override
	public long addClient(Client c) {
		// TODO Auto-generated method stub
		return dao.addClient(c);
	}
	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		return dao.getAllClients();
	}
	@Override
	public void delete(Client c) {
		dao.delete(c);
	}
	@Override
	public void maj(Client c) {
		// TODO Auto-generated method stub
		dao.maj(c);
	}

}
